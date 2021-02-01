package part03.lesson27_coroutine_parent_child

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Coroutine Parent & Child
 *
 * - Selain coroutine scope, coroutine sendiri bisa memiliki child coroutine.
 * - Saat membuat coroutine child, secara otomatis kita akan mewarisi coroutine
 *   context yang ada di coroutine parent.
 * - Dan coroutine parent akan menunggu sampai eksekusi coroutine child nya
 *   selesai semua.
 */
class CoroutineParentChild {

    @Test
    fun testParentChild() {
        runBlocking {
            val job = GlobalScope.launch {
                launch {
                    delay(2000)
                    println("Child 1 Finish")
                }
                launch {
                    delay(3000)
                    println("Child 2 Finish")
                }
                delay(1000)
                println("Parent Finish")
            }
            job.join()
        }
    }

}