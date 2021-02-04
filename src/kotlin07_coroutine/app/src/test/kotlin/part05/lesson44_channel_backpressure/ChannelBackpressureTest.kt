package part05.lesson44_channel_backpressure

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Channel Buffer
 *
 * - Secara default, channel hanya bisa menampung satu data, artinya jika kita
 *   mencoba mengirim data lain ke channel, maka kita harus menunggu data yang ada
 *   diambil.
 * - Namun kita bisa menambahkan buffer di dalam channel atau istilahnya capacity. Jadi defaultnya capacity nya adalah 0 (buffer atau antrian yang bisa ditampung).
 */
/*
    Contoh Constant Channel Capacity
    ----------------------------------------------------------------------------
    |       Constant      |       Capacity        |          Keterangan        |
    ----------------------------------------------------------------------------
    | Channel.UNLIMITED   | int.MAX_VALUE         | Total kapasitas buffernya  |
    |                     |                       | int.MAX_VALUE atau bisa    |
    |                     |                       | dibilang unlimited         |
    |--------------------------------------------------------------------------|
    | Channel.RENDEZVOUS  | 0                     | Tidak memiliki buffer      |
    |--------------------------------------------------------------------------|
    | Channel.BUFFER      | 64 atau bisa setting  | Total kapasitas buffernya  |
    |                     | via properties        | 64 atau sesuai properties  |
    |--------------------------------------------------------------------------|
    | Channel.CONFLATED   | -1                    | Total kapasitas buffernya  |
    |                     |                       | adalah -1, apabila data    |
    |                     |                       | pertama yang dikirim belum |
    |                     |                       | diambil, maka data pertama |
    |                     |                       | akan direplace dengan data |
    |                     |                       | kedua                      |
    ----------------------------------------------------------------------------
 */
class ChannelBackpressureTest {

    /**
     * Channel dengan Capacity UNLIMITED
     */
    @Test
    fun testChannelUnlimited() {
        runBlocking {
            val channel = Channel<Int>(capacity = Channel.UNLIMITED)
            val job = launch {
                println("Send 1")
                channel.send(1)
                println("Send 2")
                channel.send(2)
            }
            job.join()
            channel.close()
        }
    }

    /*
     * Channel dengan Capacity CONFLATED
     */
    @Test
    fun testChanneConflated() {
        runBlocking {
            val channel = Channel<Int>(capacity = Channel.CONFLATED)
            val job1 = launch {
                println("Send 1")
                channel.send(1)
                println("Send 2")
                channel.send(2)
            }
            job1.join()
            val job2 = launch {
                println("Receive ${channel.receive()}")
            }
            job2.join()
            channel.close()
        }
    }

}