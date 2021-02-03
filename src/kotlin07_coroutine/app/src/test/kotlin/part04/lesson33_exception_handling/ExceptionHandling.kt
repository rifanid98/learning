package part04.lesson33_exception_handling

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class ExceptionHandling {

    /**
     * Exception Propagation
     *
     * - Secara garis besar, exception di coroutine itu ada yang di ekspose ke
     *   yang memanggil coroutine ada yang tidak.
     * - Pada launch, exception tidak akan di ekspose ketika memanggil function
     *   join, namun pada async exception akan di expose ketika memanggil
     *   function await.
     */
    @Test
    fun testExceptionLaunch() {
        runBlocking {
            val job = GlobalScope.launch {
                println("Launch Coroutine")
                throw IllegalArgumentException()
            }
            job.join()
            println("Finish Coroutine")
        }
    }

    @Test
    fun testExceptionAsync() {
        runBlocking {
            val deferred = GlobalScope.async<String> {
                println("Launch Coroutine")
                throw IllegalArgumentException()
            }
            try {
                val result = deferred.await()
                println("Finish Async")
            } finally {
                println("Finally Async")
            }
        }
    }

    /**
     * Coroutine Exception Handler
     *
     * - Kadang kita ingin mengatur cara penangkapan exception di coroutine, hal
     *   ini bisa dilakukan dengan menggunakan interface CoroutineExceptionHandler.
     * - CoroutineExceptionHandler adalah turunan dari CoroutineContext.Element,
     *   sehingga kita bisa menambahkannya kedalam coroutine context.
     * - Ingat jenis CancellationException (dan turunannya) tidak akan diteruskan
     *   ke exception handler.
     * - Coroutine exception handler hanya jalan di launch, tidak jalan di async,
     *   untuk async, kita tetap harus menangkap exception nya secara manual .
     */
    @Test
    fun testExceptionHandler() {
        val exceptionHandler = CoroutineExceptionHandler {coroutineContext, throwable ->
            println("Ups, error with message ${throwable.message}")
        }
        val scope = CoroutineScope(exceptionHandler + Dispatchers.IO)
        val job = scope.launch(exceptionHandler) {
            println("Job Run")
            throw IllegalArgumentException("Ups")
        }
        runBlocking {
            job.join()
        }
    }

}