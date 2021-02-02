package part04.lesson31_yield_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

/**
 * Yield Function
 *
 * - Seperti yang pernah kita bahas sebelumnya, bahwa suspend function akan
 *   dijalankan secara sequential, artinya jika ada sebuah suspend function yang
 *   panjang dan lama, ada baiknya kita beri kesempatan ke suspend function
 *   lainnya untuk dijalankan..
 * - Coroutine berjalan secara concurrent, artinya 1 dispatcher bisa digunakan
 *   untuk mengeksekusi beberapa coroutine secara bergantian. Saat coroutine kita
 *   berjalan, dan jika kita ingin memberi kesempatan ke coroutine yang lain
 *   untuk berjalan, kita bisa menggunakan yield function.
 * - yield function itu bisa di cancel, artinya jika sebuah coroutine telah
 *   dibatalkan, maka secara otomatis yield function akan throw
 *   CancellationException.
 */
class YieldFunction {

    suspend fun runJob1(number: Int) {
        println("Start job $number : ${Thread.currentThread().name}")
        println("End job $number : ${Thread.currentThread().name}")
    }

    /**
     * Sequential Coroutine
     */
    @Test
    fun testSequential1() {
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)
        runBlocking {
            scope.launch { runJob1(1) }
            scope.launch { runJob1(2) }
            delay(2000)
        }
    }

    /**
     * Yield Function
     */
    suspend fun runJob2(number: Int) {
        println("Start job $number : ${Thread.currentThread().name}")
        yield()
        println("End job $number : ${Thread.currentThread().name}")
    }

    @Test
    fun testSequential2() {
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)
        runBlocking {
            scope.launch { runJob2(1) }
            scope.launch { runJob2(2) }
            delay(2000)
        }
    }

}