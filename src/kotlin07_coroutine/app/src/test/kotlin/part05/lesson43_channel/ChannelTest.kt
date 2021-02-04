package part05.lesson43_channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Channel
 *
 * - Channel adalah fitur di Kotlin Coroutine yang bisa digunakan untuk
 *   mentransfer aliran data dari satu tempat ke tempat lain.
 * - Channel mirip struktur data queue, dimana ada data masuk dan ada data keluar.
 * - Untuk mengirim data ke channel, kita bisa menggunakan function send() dan
 *   untuk mengambil data di channel kita bisa menggunakan function receive().
 * - Channel itu sifatnya blocking, artinya jika tidak ada data di channel, saat
 *   kita mengambil data menggunakan receive() maka dia akan menunggu sampai ada
 *   data. Dan begitu juga ketika ada data di channel, dan tidak ada yang
 *   mengambilnya, saat kita send() data, dia akan menunggu sampai channel kosong (datanya diambil).
 * - Untuk menutup channel, kita bisa menggunakan function close().
 */
class ChannelTest {

    @Test
    fun testChannel() {
        runBlocking {
            val channel = Channel<Int>()
            val job1 = launch {
                println("Send 1")
                channel.send(1)
                println("Send 2")
                channel.send(2)
            }
            val job2 = launch {
                println("Receive ${channel.receive()}")
                println("Receive ${channel.receive()}")
            }
            joinAll(job1, job2)
            channel.close()
        }
    }

}