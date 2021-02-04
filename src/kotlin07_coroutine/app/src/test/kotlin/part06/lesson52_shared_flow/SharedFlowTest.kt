package part06.lesson52_shared_flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import org.junit.jupiter.api.Test
import java.util.*

/**
 * Shared Flow vs Flow
 *
 * - Shared Flow adalah turunan dari Flow, sehingga apa yang bisa dilakukan di
 *   Flow, bisa juga dilakukan di Shared Flow.
 * - Kemampuan Shared Flow yang tidak dimiliki oleh Flow adalah, pada Shared Flow,
 *   kita bisa membuat lebih dari satu receiver.
 * - Selain itu Shared Flow bersifat aktif atau hot, yang artinya ketika kita
 *   mengirim data ke Shared Flow, data langsung dikirim ke receiver tanpa perlu
 *   di collect terlebih dahulu oleh si receiver.
 *
 * Shared Flow vs Broadcast Channel
 *
 * - Shared Flow mulai dikenalkan di Kotlin 1.4.
 * - Shared Flow dirancang sebagai pengganti Broadcast Channel.
 * - Shared Flow adalah turunan dari Flow, sehingga mendukung semua Flow operator,
 *   hal ini yang sangat membedakan dengan Channel yang hanya bisa menggunakan
 *   receive() untuk menerima data, di Shared Flow, kita bisa melakukan operasi
 *   apapun bawaan dari Flow operator.
 * - Shared Flow mendukung configurable buffer overflow strategy karena bisa
 *   menggunakan Flow Operator.
 * - Shared Flow bukanlah channel, sehingga tidak ada operasi close.
 * - Untuk membuat receiver dari Shared Flow, kita bisa menggunakan function
 *   asSharedFlow().
 */
class SharedFlowTest {

    @Test
    fun testSharedFlow() {
        val sharedFlow = MutableSharedFlow<Int>(10)
        val scope = CoroutineScope(Dispatchers.IO)
        runBlocking {
            scope.launch { repeat(10) { delay(1000); sharedFlow.emit(it); println("emit $it") } }
            scope.launch {
                sharedFlow.asSharedFlow().collect() {
                    delay(1000); println("Shared flow 1 receive $it ${Date()}")
                }
            }
            scope.launch {
                sharedFlow.asSharedFlow().collect() {
                    delay(2000); println("Shared flow 2 receive $it ${Date()}")
                }
            }
            delay(21_000)
            scope.cancel()
        }
    }

}