package part05.lesson42_cancellable_flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.junit.jupiter.api.Test

/**
 * Membatalkan Flow
 *
 * - Flow adalah coroutine, artinya dia bisa dibatalkan.
 * - Untuk membatalkan flow, caranya sangat mudah, kita bisa menggunakan function
 *   cancel() milik coroutine scope, function cancel() tersebut akan secara
 *   otomatis membatalkan job coroutine.
 */
class CancellableFlowTest {

    fun numberFlow(): Flow<Int> {
        return flow {
            repeat(100) {
                emit(it)
            }
        }
    }

    @Test
    fun testCancellableFlow() {
        val flow = numberFlow()
        val scope = CoroutineScope(Dispatchers.IO)
        runBlocking {
            scope.launch {
                flow.onEach {
                    if (it > 10) cancel()
                    else println("Number $it in ${Thread.currentThread().name}")
                }.collect()
            }.join()
        }
    }

}