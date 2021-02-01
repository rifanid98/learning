package part03.lesson21_membuat_coroutine_dispatcher

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

/**
 * Membuat Coroutine Dispatcher
 *
 * - Saat membuat aplikasi, kadang kita ingin flexible menentukan thread yang akan
 *   kita gunakan untuk  menjalankan coroutine.
 * - Misal, kita ingin membedakan thread untuk layer web, layer http client, dan
 *   lain-lain.
 * - Oleh karena ini, membuat Coroutine Dispatcher sendiri sangat direkomendasikan.
 * - Untuk membuat Coroutine Dispatcher secara manual, kita bisa melakukannya
 *   dengan cara menggunakan ExecutorService.
 */
class CreateCoroutineDispatcher {

    @Test
    fun TestCreateDispatcher() {
        val dispatcherService = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val dispatcherWeb = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        runBlocking {
            val job1 = GlobalScope.launch(dispatcherService) {
                println("Service run in thread ${Thread.currentThread().name}")
            }
            val job2 = GlobalScope.launch(dispatcherWeb) {
                println("Web run in thread ${Thread.currentThread().name}")
            }
            joinAll(job1, job2)
        }
    }

}
