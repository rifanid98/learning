package part03.lesson29_coroutine_name

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

/**
 * Memberi Nama Coroutine
 *
 * - Selain dispatcher, salah satu coroutine context yang lain adalah
 *   CoroutineName.
 * - CoroutineName bisa kita gunakan untuk mengubah nama coroutine sesuai dengan
 *   yang kita mau.
 * - Hal ini sangat bermanfaat ketika kita melakukan proses debugging.
 */
class NameCoroutine {

    @Test
    fun testName() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch(CoroutineName("Parent")) {
            println("Run in thread ${Thread.currentThread().name}")
            withContext(CoroutineName("Child")) {
                println("Run in thread ${Thread.currentThread().name}")
            }
        }
        runBlocking {
            job.join()
        }
    }

}