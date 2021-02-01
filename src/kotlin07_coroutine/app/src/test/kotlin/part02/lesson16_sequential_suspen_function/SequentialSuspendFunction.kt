package part02.lesson16_sequential_suspen_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class SequentialSuspendFunction {

    suspend fun getFoo(): Int {
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        return 10
    }

    /**
     * Suspend Function Tidak Async
     *
     * - Secara default, sebenarnya sebuah suspend function tidaklah async, saat
     *   kita mengakses beberapa suspend function, semua akan dieksekusi secara
     *   sequential.
     */
    @Test
    fun testSuspend() {
        runBlocking {
            val total = measureTimeMillis {
                getFoo()
                getBar()
            }
            println("Total time $total")
        }
    }

    /**
     * Concurrent Dengan Launch
     *
     * - Jadi agar sebuah suspend function bisa berjalan secara concurrent, kita
     *   perlu menggunakan function launch ketika memanggil suspend function
     *   tersebut.
     * - Hal yang menyulitkan adalah, launch function mengembalikan Job, dan di
     *   dalam Job, kita tidak bisa mengembalikan nilai hasil dari coroutine.
     * - Hal ini bisa dianalogikan bahwa launch itu alah menjalankan coroutine yang
     *   mengembalikan nilai Unit (tidak mengembalikan nilai).
     */
    @Test
    fun testSuspendConcurrent() {
        runBlocking {
            val total = measureTimeMillis {
                val job1 = GlobalScope.launch { getFoo() }
                val job2 = GlobalScope.launch { getBar() }

                joinAll(job1, job2)
            }
            println("Total time $total")
        }
    }

}