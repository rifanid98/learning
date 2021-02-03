package part04.lesson35_supervisor_scope_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.util.concurrent.Executors

/**
 * supervisorScope Function
 *
 * - Kadang ada kondisi dimana kita tidak memiliki akses untuk mengubah sebuah
 *   coroutine scope.
 * - Karena secara default sifatnya adalah Job, maka kita bisa menggunakan
 *   supervisorScope function untuk membuat coroutine yang sifatnya SupervisorJob.
 */
class SupervisorScopeFunction {

    @Test
    fun testSupervisorScopeFunction() {
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope = CoroutineScope(Job() + dispatcher)
        runBlocking {
            scope.launch {
                supervisorScope {
                    launch {
                        delay(2000)
                        println("Job 1 complete")
                    }
                    launch {
                        delay(1000)
                        throw IllegalArgumentException("Job 2 failed")
                    }
                }
            }.join()
        }
    }

}