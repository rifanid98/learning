package part01.lesson10_coroutine_ringan

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.concurrent.thread

/**
 * Coroutine Sangat Ringan
 *
 * - Seperti yang sebelumnya dibahas, coroutine itu ringan dan cepat, sehingga
 *   saat kita membuat coroutine dalam jumlah besar, ini tidak akan berdampak
 *   terlalu besar dengan memory yang kita gunakan.
 * - Sekarang kita akan coba bandingkan membuat thread dan coroutine dalam jumlah
 *   banyak.
 */
class CoroutineRingan {

    @Test
    fun testThread() {
        repeat(1000) {
            thread {
                Thread.sleep(1000)
                println("Thread $it : ${Date()}")
            }
        }

        println("Waiting")
        Thread.sleep(10000)
        println("Done")
    }

    @Test
    fun testCoroutine() {
        repeat(10000) {
            GlobalScope.launch {
                delay(1000)
                println("Thread $it : ${Date()} ${Thread.currentThread().name}")
            }
        }

        println("Waiting")
        runBlocking {
            delay(3000)
        }
        println("Done")
    }

}