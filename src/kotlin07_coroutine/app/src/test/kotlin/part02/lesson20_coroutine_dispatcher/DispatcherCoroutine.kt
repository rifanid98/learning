package part02.lesson20_coroutine_dispatcher

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class DispatcherCoroutine {

    /**
     * Coroutine Dispatcher
     *
     * - Selain ada Job di dalam CoroutineContext, ada juga object CoroutineDispatcher.
     * - CoroutineDispatcher digunakan untuk menentukan thread mana yang bertanggung
     *   jawab untuk mengeksekusi coroutine.
     * - Secara default sudah ada setting default dispatcher, namun kita bisa
     *   menggantinya jika kita mau.
     *
     * Dispatchers
     * Ada object Dispatchers yang bisa kita gunakan untuk mengganti CoroutineDispatcher.
     * - Dispatchers.Default, ini adalah default dispatcher, isinya minimal 2 thread,
     *   atau sebanyak jumlah cpu (mana yang lebih banyak). Dispatcher ini cocok
     *   untuk proses coroutine yang cpu-bound.
     * - Dispatcher.IO, ini adalah dispatcher yang berisikan thread sesuai dengan
     *   kebutuhan, ketika butuh akan dibuat, ketika sudah tidak dibutuhkan, akan
     *   dihapus, mirip cache thread pool di executor service. Dispatcher ini akan
     *   sharing thread dengan Default dispatcher.
     * - Dispatchers.Main, ini adalah dispatchers yang berisikan main thread UI, cocok
     *   ketika kita butuh running di thread main seperti di Java Swing, JavaFX atau
     *   Android. Untuk menggunakan ini, kita harus menambah library ui tambahan.
     */
    @Test
    fun testDispatcher() {
        println("Unit test in thread ${Thread.currentThread().name}")
        runBlocking {
            println("runBlocking in thread ${Thread.currentThread().name}")
            val job1 = GlobalScope.launch(Dispatchers.Default) {
                println("Job 1 run in thread ${Thread.currentThread().name}")
            }
            val job2 = GlobalScope.launch(Dispatchers.IO) {
                println("Job 2 run in thread ${Thread.currentThread().name}")
            }
            joinAll(job1, job2)
        }
    }

    /**
     * Unconfined vc Confined
     * Selain Default, IO dan Main, ada juga beberapa dispatchers yang lain
     *
     * - Dispatchers.Unconfined, ini adalah dispatcher yang tidak menunjuk thread
     *   apapun, biasanya akan melanjutkan thread di coroutine sebelumnya.
     * - Confined (tanpa parameter), ini adalah dispatcher yang akan melanjutkan
     *   thread dari coroutine sebelumnya.
     *
     * Apa bedanya Unconfined dan Confined, pada Unconfined, thread bisa berubah di
     * tengah jalan jika memang terdapat code yang melakukan perubahan thread
     */
    @Test
    fun testRunBlocking() {
        runBlocking {
            GlobalScope.launch(Dispatchers.Unconfined) {
                println("Unconfined: in thread ${Thread.currentThread().name}")
                delay(1000)
                println("Unconfined: in thread ${Thread.currentThread().name}")
            }
            GlobalScope.launch {
                println("Confined: in thread ${Thread.currentThread().name}")
                delay(1000)
                println("Confined: in thread ${Thread.currentThread().name}")
            }
            delay(3000)
        }
    }

}