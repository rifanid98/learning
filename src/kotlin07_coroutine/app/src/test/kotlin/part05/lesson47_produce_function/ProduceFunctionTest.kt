package part05.lesson47_produce_function

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Produce Function
 *
 * - Coroutine scope memiliki sebuah function bernama produce, ini digunakan untuk
 *   membuat sebuah coroutine yang digunakan untuk mengirim data ke channel,
 *   sederhananya kita bisa membuat channel secara mudah dengan menggunakan
 *   function produce ini.
 * - Hasil return dari produce adalah ReceiveChannel (parent interface dari
 *   Channel), yang hanya bisa digunakan untuk mengambil data.
 */
class ProduceFunctionTest {

    @Test
    fun testProduce() {
        val scope = CoroutineScope(Dispatchers.IO)
        runBlocking {
            val channel: ReceiveChannel<Int> = scope.produce(capacity = 20) {
                repeat(10) { send(it) }
            }
            val job = launch {
                repeat(10) { println("Receive ${channel.receive()}") }
            }.join()
        }
    }

}