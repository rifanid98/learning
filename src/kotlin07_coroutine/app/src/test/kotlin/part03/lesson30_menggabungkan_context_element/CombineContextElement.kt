package part03.lesson30_menggabungkan_context_element

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

/**
 * Menggabungkan Context Element
 *
 * - Seperti yang pernah dibahas di materi CoroutineContext.
 * - CoroutineContext adalah kompulan dari Element-Element, contoh turunannya
 *   adalah Job, CoroutineDispatcher dan yang terakhir yang sempat kita bahas
 *   adalah CoroutineName.
 * - CoroutineContext memiliki method plus, sehingga sebenarnya kita bisa
 *   menggabungkan beberapa context element secara sekaligus, misal Dispatcher dan
 *   CoroutineName misalnya.
 */
class CombineContextElement {

    @Test
    fun testCombineContextElement() {
        val dispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher + CoroutineName("Parent"))
        val job = scope.launch {
            println("Run in thread : ${Thread.currentThread().name}")
            withContext(Dispatchers.IO + CoroutineName("Child")) {
                println("Run in thread : ${Thread.currentThread().name}")
            }
        }
        runBlocking {
            job.join()
        }
    }

}