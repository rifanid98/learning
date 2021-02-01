package part03.lesson28_cancel_children_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

/**
 * cancelChildren Function
 *
 * - Sebelumnya sudah dibahas kalo coroutine itu memiliki parent dan child.
 * - Coroutine akan direpresentasikan sebagai Job (Deferred tuturan dari Job),
 *   dan di Job kita bisa mendapatkan semua children nya menggunakan field
 *   children.
 * - Selain itu ada sebuah function bernama cancelChildren, function ini bisa kita
 *   gunakan untuk membatalkan semua coroutine children.
 * - Jika kita membatalkan Job parent, kita tidak perlu membatalkan children nya
 *   secara manual, karena saat Job di batalkan, semua child nya akan dibatalkan.
 */
class CancelChildrenFunction {

    @Test
    fun testCancelChildren() {
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
            delay(2000)
            job.cancelChildren()
            job.join()
        }
    }

}