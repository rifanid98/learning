package part03.lesson23_non_cancellable_context

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

class NonCancellableContext {

    /**
     * Check isActive di Finally
     *
     * - Sebelumnya kita tahu bahwa setelah coroutine di cancel, dan jika kita
     *   ingin melakukan sesuatu, kita bisa menggunakan block try-finally.
     * - Namun dalam block finally, kita tidak bisa menggunakan suspend method
     *   yang mengecek isActive, karena otomatis akan bernilai false, dan otomatis
     *   batal.
     */
    @Test
    fun testCancelFinally() {
        runBlocking {
            val job =GlobalScope.launch {
                try {
                    println("Hello ${Date()}")
                } finally {
                    println(isActive)
                    delay(1000)
                    println("Finally")
                }
            }
            job.cancelAndJoin()
        }
    }

    /**
     * Non Cancellable Context
     *
     * - Jika kita butuh memanggil suspend function yang mengecek isActive di block
     *   finally, dan berharap tidak dibatalkan eksekusinya, maka kita bisa
     *   menggunakan NonCancellable.
     * - NonCancellable adalah coroutine context yang mengoverride nilai-nilai
     *   cancellable sehingga seakan-akan coroutine tersebut tidak di batalkan.
     */
    @Test
    fun testNonCancellable() {
        runBlocking {
            val job = GlobalScope.launch {
                try {
                    println("Hello ${Date()}")
                } finally {
                    withContext(NonCancellable) {
                        println(isActive)
                        delay(1000)
                        println("Finally")
                    }
                }
            }
            job.cancelAndJoin()
        }
    }
}