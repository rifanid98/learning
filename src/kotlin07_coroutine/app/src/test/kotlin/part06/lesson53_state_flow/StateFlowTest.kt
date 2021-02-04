package part06.lesson53_state_flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import org.junit.jupiter.api.Test

/**
 * State Flow
 *
 * - State Flow adalah turunan dari Shared Flow, artinya di State Flow, kita bisa
 *   membuat banyak receiver.
 * - Pada State Flow, receiver hanya akan menerima data paling baru.
 * - Jadi jika ada receiver yang sangat lambat dan sender mengirim data terlalu
 *   cepat, yang akan diterima oleh receiver adalah data paling akhir.
 * - State Flow cocok digunakan untuk maintain state, dimana memang biasanya state
 *   itu biasanya hanya satu data, tidak peduli berapa kali perubahan data
 *   tersebut, yang paling penting pada state adalah data terakhir.
 * - Untuk mendapatkan data state nya, kita bisa menggunakan field value di State
 *   Flow.
 * - Untuk membuat receiver kita bisa menggunakan asStateFlow().
 */
class StateFlowTest {

    @Test
    fun testStateFlow() {
        val stateFlow = MutableStateFlow(value = 0)
        val scope = CoroutineScope(Dispatchers.IO)
        runBlocking {
            scope.launch {
                repeat(10) {
                    delay(1000); stateFlow.emit(it)
                }
            }
            scope.launch {
                val stateFlow1 = stateFlow.asStateFlow()
                stateFlow1.collect() {
                    delay(2000)
                    println("State Flow 1 receive $it")
                }
            }
            delay(10_000)
            scope.cancel()
        }
    }

}