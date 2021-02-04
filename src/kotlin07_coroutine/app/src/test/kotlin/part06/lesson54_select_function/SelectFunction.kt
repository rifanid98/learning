package part06.lesson54_select_function

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.selects.select
import org.junit.jupiter.api.Test

/**
 * select Function
 *
 * - select Function memungkinkan kita untuk menunggu beberapa suspending function
 *   dan memilih yang pertama datanya tersedia.
 * - select Function bisa digunakan di Deferred dan juga Channel.
 * - Untuk Deffered, kita bisa menggunakan onAwait.
 * - dan untuk ReceiveChannel, kita bisa menggunakan onReceive.
 */
class SelectFunction {

    /**
     * select Function untuk Deferred
     */
    @Test
    fun testSelectDeferred() {
        val scope = CoroutineScope(Dispatchers.IO)
        val deferred1 = scope.async { delay(1000); 1000 }
        val deferred2 = scope.async { delay(2000); 2000 }
        runBlocking {
            val win = select<Int> {
                deferred1.onAwait { it }
                deferred2.onAwait { it }
            }
            println("Win $win")
        }
    }

    /**
     * select Function untuk Channel
     */
    @Test
    fun testSelectChannel() {
        val scope = CoroutineScope(Dispatchers.IO)
        val channel1 = scope.produce { delay(1000); send(1000) }
        val channel2 = scope.produce { delay(2000); send(2000) }
        runBlocking {
            val win = select<Int> {
                channel1.onReceive { it }
                channel2.onReceive { it }
            }
            println("Win $win")
        }
    }

    /**
     * select Function untuk Channel + Deferred
     */
    @Test
    fun testSelectChannelDeferred() {
        val scope = CoroutineScope(Dispatchers.IO)
        val channel1 = scope.produce { delay(1000); send(1000) }
        val channel2 = scope.produce { delay(2000); send(2000) }
        val deferred = scope.async { delay(3000); 3000}
        runBlocking {
            val win = select<Int> {
                channel1.onReceive { it }
                channel2.onReceive { it }
                deferred.onAwait { it }
            }
            println("Win $win")
        }
    }

}