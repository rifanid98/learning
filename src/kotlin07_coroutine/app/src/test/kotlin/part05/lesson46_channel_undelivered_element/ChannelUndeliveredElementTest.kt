package part05.lesson46_channel_undelivered_element

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Channel Undelivered Element
 *
 * - Kadang ada kasus dimana sebuah channel sudah di close, tetapi ada coroutine
 *   yang masih mencoba mengirim data ke channel.
 * - Ketika kita mencoba mengirim data ke channel yang sudah close, maka secara
 *   otomatis channel akan mengembalikan error ClosedSendChannelException.
 * - Namun pertanyaannya, bagaimana dengan data yang sudah dikirim?
 * - Kita bisa menambah lambda function ketika membuat channel, sebagai fallback
 *   ketika sebuah data dikirim dan channel sudah di close, maka fallback tersebut
 *   akan dieksekusi.
 * - Function fallback tersebut bernama onUndeliveredElement.
 */
class ChannelUndeliveredElementTest {

    @Test
    fun testChannelUndelivered() {
        runBlocking {
            val channel = Channel<Int>(Channel.UNLIMITED) { value ->
                println("Undelivered value $value")
            }
            channel.close()
            val job = launch {
                channel.send(10)
            }
            job.join()
        }
    }

}