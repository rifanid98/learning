package part05.lesson45_channel_buffer_overflow

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Channel Buffer Overflow
 *
 * - Walaupun kita sudah menggunakan buffer, ada kalanya buffer sudah penuh, dan
 *   sender tetap mengirimkan data.
 * - Dalam kasus seperti ini, kita bisa menggunakan beberapa strategy.
 * - Untuk mengatur ketika terjadi buffer overflow (kelebihan data yang ditampung
 *   oleh buffer), kita bisa menggunakan enum BufferOverflow.
 */
/*
    BufferOverflow Enum
    ----------------------------------------------------------------------------
    |   BufferOverflow Enum |                    Keterangan                    |
    ----------------------------------------------------------------------------
    |   SUSPEND             | BLock Sender                                     |
    |--------------------------------------------------------------------------|
    |   DROP_OLDEST         | Hapus data di buffer yang paling lama (paling    |
    |                       | depan)                                           |
    |--------------------------------------------------------------------------|
    |   DROP_LATEST         | Hapus data di buffer yang paling baru (paling    |
    |                       | belakang)                                        |
    ----------------------------------------------------------------------------
 */
class ChannelBufferOverflow {

    @Test
    fun testChannelBufferOverflow() {
        runBlocking {
            val channel = Channel<Int>(
                capacity = 5,
                onBufferOverflow = BufferOverflow.DROP_OLDEST
            )
            val job1 = launch {
                repeat(10) {
                    channel.send(it)
                }
            }
            job1.join()
            delay(1000)
            val job2 = launch {
                repeat(5) {
                    println("Receive ${channel.receive()}")
                }
            }
            job2.join()
        }
    }

}