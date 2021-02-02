package part04.lesson32_await_cancellation_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

/**
 * awaitCancellation Function
 *
 * - Secara default, sebuah coroutine akan berhenti ketika seluruh code selesai
 *   dijalankan.
 * - Jika ada kebutuhan kita tidak mau coroutine berhenti sampai di Job nya di
 *   cancel, maka kita bisa menggunakan function awaitCancellation.
 * - Function awaitCancellation akan throw CancellationException jika job di
 *   cancel, dan tidak akan menghentikan coroutine jika belum di cancel.
 */
class AwaitCancellationFunction {

    @Test
    fun testAwaitCancellation() {
        runBlocking {
            val job = launch {
                try {
                    println("Do something")
                    awaitCancellation()
                } finally {
                    println("Coroutine cancelled")
                }
            }
            delay(5000)
            job.cancelAndJoin()
        }
    }

}