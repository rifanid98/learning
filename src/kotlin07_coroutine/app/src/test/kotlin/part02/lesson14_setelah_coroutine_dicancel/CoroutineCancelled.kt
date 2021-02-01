package part02.lesson14_setelah_coroutine_dicancel

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * Setelah Coroutine di Cancel
 *
 * - Standard coroutine adalah, ketika sebuah coroutine dibatalkan, maka kita
 *   perlu throw CancellableException.
 * - Karena throw CancellableException, artinya jika kita ingin melakukan sesuatu
 *   ketika sebuah coroutine dibatalkan, kita bisa menggunakan block try-finally.
 */
class CoroutineCancelled {

    @Test
    fun testCancelFinallyCoroutine() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                try {
                    println("Hello ${Date()}")
                    delay(2000)
                    println("World ${Date()}")
                } finally {
                    println("Finally")
                }
            }
            job.cancelAndJoin()
        }
    }

}