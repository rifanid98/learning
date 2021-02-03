package part04.lesson38_semaphore

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

/**
 * Semaphore
 *
 * - Sama seperti Mutex, Semaphore juga digunakan sebagai object untuk locking.
 * - Namun yang membedakan, pada Mutex, kita hanya memperbolehkan 1 coroutine yang
 *   bisa mengakses nya pada satu waktu.
 * - Namun pada Semaphore, kita bisa menentukan berapa jumlah corotine yang boleh
 *   mengakses nya pada satu waktu.
 */
class SemaphoreTest {

    @Test
    fun testSemaphore() {
        var counter = 0
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)
        val semaphore = Semaphore(permits = 2)
        repeat(100) {
            scope.launch {
                repeat(1000) {
                    semaphore.withPermit {
                        counter++
                    }
                }
            }
        }
        runBlocking { delay(2_000) }
        println("Total counter : $counter")
    }

}