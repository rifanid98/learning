package part05.lesson48_broadcast_channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.broadcast
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Broadcast Channel
 *
 * - Secara default channel hanya boleh memiliki 1 receiver.
 * - Namun Kotlin Coroutine mendukung Broadcast Channel, ini adalah channel khusus
 *   yang receiver nya bisa lebih dari satu.
 * - Setiap kita mengirim data ke channel ini, secara otomatis semua receiver bisa
 *   mendapatkan data tersebut.
 * - BroadcastChannel memiliki function openSubscription() untuk membuat
 *   ReceiveChannel baru.
 * - Broadcast channel tidak mendukung kapasitas buffer 0 dan UNLIMITED.
 *
 * Diagram Broadcast Channel
 *
 * - see README.md
 */
class BroardcastChannelTest {

    /**
     * Broadcast Channel
     */
    @Test
    fun testBroadcastChannel() {
        val broadcastChannel = BroadcastChannel<Int>(capacity = 10)
        val receiver1 = broadcastChannel.openSubscription()
        val receiver2 = broadcastChannel.openSubscription()
        val scope = CoroutineScope(Dispatchers.IO)
        runBlocking {
            scope.launch { repeat(10) {broadcastChannel.send(it)} }
            scope.launch { repeat(10) { println("Receiver 1 : ${receiver1.receive()}")} }.join()
            scope.launch { repeat(10) { println("Receiver 2 : ${receiver2.receive()}")} }.join()
        }
    }

    /**
     * broadCast Function
     */
    @Test
    fun testBroadcast() {
        val scope = CoroutineScope(Dispatchers.IO)
        val broadcastChannel: BroadcastChannel<Int> = scope.broadcast(capacity = 10) {
            repeat(10) { send(it) }
        }
        val receiver1 = broadcastChannel.openSubscription()
        val receiver2 = broadcastChannel.openSubscription()
        runBlocking {
            scope.launch { repeat(10) { println("Receiver 1 : ${receiver1.receive()}")} }.join()
            scope.launch { repeat(10) { println("Receiver 2 : ${receiver2.receive()}")} }.join()
        }
    }

}