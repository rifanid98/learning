package part04.lesson39_asynchronous_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Asynchronous Flow
 *
 * - Sampai saat ini kita hanya membahas tentang coroutine yang tidak
 *   mengembalikan value (launch) dan mengembalikan satu value (async), bagaimana
 *   jika kita butuh sebuah coroutine yang mengembalikan data berkali-kali seperti
 *   layaknya collection?
 * - Kotlin mendukung hal tersebut dengan nama Flow.
 * - Flow mirip dengan sequence di Kotlin Collection, yang membedakan adalah
 *   flow berjalan sebagai coroutine dan kita bisa menggunakan suspend function
 *   di flow.
 * - Flow adalah collection cold atau lazy, artinya jika tidak diminta datanya,
 *   flow tidak akan berjalan (kode nya tidak akan dieksekusi).
 */
class AsynchronousFlowTest {

    /**
     * Membuat Flow
     *
     * - Untuk membuat flow, kita bisa menggunakan function flow().
     * - Di dalam flow untuk mengirim data kita bisa menggunakan function emit().
     * - Untuk mengakses data yang ada di flow, kita bisa menggunakan function
     *   collect().
     */
    @Test
    fun testFlow() {
        val flow: Flow<Int> = flow {
            println("Flow started")
            repeat(10) {
                delay(1000)
                println("Emit $it")
                emit(it)
            }
        }
        runBlocking {
            flow.collect {
                println("Collect $it")
            }
        }
    }

}