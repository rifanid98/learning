package part03.lesson22_with_context_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

/**
 * withContext Function
 *
 * - Sebelumnya kita sudah tahu, bahwa ternyata saat kita melakukan delay(),
 *   suspend function tersebut akan di trigger di thread yang berbeda.
 * - Bagaimana caranya jika kita ingin menjalankan code program kita dalam
 *   coroutine di thread yang berbeda dengan thread coroutine awalnya?
 * - Untuk melakukan itu, kita bisa menggunakan function withContext().
 * - Function withContext() sebenarnya bisa kita gunakan untuk mengganti
 *   CoroutineContext, namun karena CoroutineDispatcher adalah turunan
 *   CoroutineContext, jadi kita bisa otomatis mengganti thread yang akan
 *   digunakan di coroutine menggunakan function withContext().
 */
class WithContextFunction {

    @Test
    fun testWithContext() {
        val dispatcherClient = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        runBlocking {
            val job = GlobalScope.launch(Dispatchers.IO) {
                println("1. This code run in ${Thread.currentThread().name}")
                withContext(dispatcherClient) {
                    println("2. This code run in ${Thread.currentThread().name}")
                }
                println("3. This code run in ${Thread.currentThread().name}")
            }
            job.join()
        }
    }

}