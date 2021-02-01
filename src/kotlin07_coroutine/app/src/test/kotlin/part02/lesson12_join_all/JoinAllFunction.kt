package part02.lesson12_join_all

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

/**
 * joinAll Function
 *
 * - Kadang kita akan membuat coroutine lebih dari satu sekaligus.
 * - Untuk menunggu semua Job coroutine selesai berjalan kita bisa menggunakan
 *   join() function.
 * - Namun jika kita panggil satu-satu tiap Job coroutine nya, akan sangat
 *   mengganggu sekali.
 * - Kotlin menyediakan joinAll(jobs) function untuk menunggu semua job selesai.
 */
class JoinAllFunction {

    @Test
    fun testJoinAll() {
        runBlocking {
            val job1 = GlobalScope.launch {
                delay(1000)
                println("Job 1")
            }
            val job2 = GlobalScope.launch {
                delay(2000)
                println("Job 2")
            }
            joinAll(job1, job2)
        }
    }

}