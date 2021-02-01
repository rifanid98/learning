package part02.lesson11_job

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

/**
 * Job
 *
 * - Saat sebuah coroutine dijalankan menggunakan function launch, sebenarnya
 *   function tersebut mengembalikan sebuah object Job.
 * - Dengan object Job, kita bisa menjalankan, membatalkan atau menunggu sebuah
 *   coroutine.
 */
class JobCoroutine {

    /**
     * Coroutine di runBlocking
     */
    @Test
    fun testJob() {
        runBlocking {
            GlobalScope.launch {
                delay(2000)
                println("Hello World ${Thread.currentThread().name}")
            }
            delay(3000)
        }
    }

    /**
     * Menjalankan Job
     */
    @Test
    fun testJobStart() {
        runBlocking {
            val job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) {
                delay(2000)
                println("Hello World ${Thread.currentThread().name}")
            }
            job.start()
            delay(3000)
        }
    }

    /**
     * Menunggu Job
     */
    @Test
    fun testJobJoin() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                delay(2000)
                println("Hello World ${Thread.currentThread().name}")
            }
            job.join()
        }
    }

    /**
     * Membatalkan Job
     */
    @Test
    fun testJobCancel() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                delay(2000)
                println("Hello World ${Thread.currentThread().name}")
            }
            job.cancel()
            delay(3000)
        }
    }

}