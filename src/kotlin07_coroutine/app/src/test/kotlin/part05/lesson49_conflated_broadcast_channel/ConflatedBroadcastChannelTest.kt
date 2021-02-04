package part05.lesson49_conflated_broadcast_channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import org.junit.jupiter.api.Test


/**
 * Conflated Broadcast Channel
 *
 * - Conflated Broadcast Channel adalah turunan dari Broadcast Channel, sehingga
 *   cara kerjanya sama.
 * - Pada Broadcast Channel, walaupun receiver lambat, maka receiver tetap akan
 *   mendapatkan seluruh data dari sender.
 * - Namun berbeda dengan Conflated Broadcast Channel, receiver hanya akan
 *   mendapat data paling baru dari sender.
 * - Jadi jika receiver lambat, receiver hanya akan mendapat data paling baru saja,
 *   bukan semua data.
 */
class ConflatedBroadcastChannelTest {

    @Test
    fun testConflatedChannel() {
        val broadcastChannel = ConflatedBroadcastChannel<Int>()
        val receiver = broadcastChannel.openSubscription()
        val scope = CoroutineScope(Dispatchers.IO)
        runBlocking {
            scope.launch { repeat(10) { delay(1000); broadcastChannel.send(it); println("Send $it") } }
            scope.launch { repeat(10) { delay(2000); println("Receive : ${receiver.receive()}") } }
            delay(12_000)
            scope.cancel()
        }
    }

}