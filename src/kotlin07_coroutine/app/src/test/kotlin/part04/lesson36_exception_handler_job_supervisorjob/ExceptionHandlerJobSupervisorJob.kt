package part04.lesson36_exception_handler_job_supervisorjob

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.util.concurrent.Executors

class ExceptionHandlerJobSupervisorJob {

    /**
     * Exception Handler di Job dan Supervisor Job
     *
     * - Exception handler di Job ataupun di Supervisor Job secara default akan di propagate ke parent nya.
     * - Artinya jika kita membuat CoroutineExceptionHandler, kita harus membuatnya di parent, tidak bisa di coroutine child nya.
     * - Jika kita menambahkan exception handler di coroutine child nya, maka itu tidak akan pernah digunakan.
     */
    /**
     * Exception Handler Salah di Job
     */
    @Test
    fun testExceptionJob() {
        val exceptionHandler = CoroutineExceptionHandler() {coroutineContext, throwable ->
            println("Error happen ${throwable.message}")
        }
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)

        runBlocking {
            val job = scope.launch {
                launch(exceptionHandler) { // wrong, error will propagate to parent
                    println("Job 1")
                    throw IllegalArgumentException("Job 1 failed")
                }
            }
            joinAll(job)
        }
    }

    /**
     * Exception Handler dengan supervisorScope
     *
     * - Salah satu cara agar exception handler bisa dilakukan di coroutine child
     *   adalah dengan menggunakan supervisorScope.
     * - Saat menggunakan supervisorScope, maka exception bisa di gunakan di parent
     *   coroutine di supervisorScope, atau sebenarnya coroutine child di scope yang
     *   ada diatas nya.
     * - Tapi ingan jika terjadi error di child nya coroutine yang ada di
     *   supervisorScope, maka tetap akan di propagate ke parent coroutine di
     *   cupervisorScope.
     */
    /**
     * Exception Handler supervisorScope
     */
    @Test
    fun testExceptionSupervisorJob() {
        val exceptionHandler = CoroutineExceptionHandler {coroutineContext, throwable ->
            println("Error happen ${throwable.message}")
        }
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope = CoroutineScope(Job() + dispatcher)
        runBlocking {
            val job = scope.launch {
                supervisorScope {
                    launch(exceptionHandler) {
                        launch {
                            println("Job 1")
                            throw IllegalArgumentException("Job 1 failed")
                        }
                    }
                }
            }
            job.join()
        }
    }

}