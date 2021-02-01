package part01.lesson04_multiple_thread

import org.junit.jupiter.api.Test
import java.util.*

/**
 * Multiple Thread
 *
 * - Tidak ada batasan dalam membuat Thread.
 * - Kita bisa membuat Thread sebanyak yang kita mau.
 * - Semua Thread akan berjalan sendiri-sendiri secara paralel.
 */
class MultipleThread {

    @Test
    fun multipleThread() {
        val thread1: Thread = Thread {
            Thread.sleep(1000)
            println(Date())
            println("Hello ${Thread.currentThread().name}")
        }

        val thread2: Thread = Thread {
            Thread.sleep(2000)
            println(Date())
            println("Hello ${Thread.currentThread().name}")
        }

        thread1.start()
        thread2.start()
        Thread.sleep(3000)
        println("Threads Done ${Date()}")
    }
}