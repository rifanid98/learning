package part05.lesson50_actor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Actor
 *
 * - Saat kita menggunakan produce() function, kita membuat coroutine sekaligus
 *   sebagai channel sender nya.
 * - Untuk membuat coroutine sekaligus channel receiver, kita bisa menggunakan
 *   actor() function.
 * - Konsep seperti dikenal dengan konsep Actor Model.
 *
 * Diagram Actor Model
 *
 * - see README.md
 */
class ActorTest {

    @Test
    fun testActor() {
        val scope = CoroutineScope(Dispatchers.IO)
        runBlocking {
            val sendCahnnel = scope.actor<Int>(capacity = 10) {
                repeat(10) { println("Receive ${receive()}") }
            }
            val job = launch { repeat(10) { sendCahnnel.send(it) } }
            job.join()
            sendCahnnel.close()
        }
    }

}