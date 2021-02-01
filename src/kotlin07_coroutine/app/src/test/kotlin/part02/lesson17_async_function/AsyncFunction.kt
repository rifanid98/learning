package part02.lesson17_async_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * Async Function
 *
 * - Untuk membuat coroutine, kita tidak hanya bisa menggunakan function launch,
 *   ada function async yang bisa kita gunakan juga untuk membuat coroutine.
 * - Berbeda dengan launch function yang mengembalikan Job, async function
 *   mengembalikan Deferred.
 * - Deferred adalah turunan dari Job, yang membedakan adalah, Deferred membawa
 *   value hasil dari async function.
 * - Deferred itu mirip konsep Promise atau Future, dimana datanya akan ada nanti.
 * - Jika kita ingin menunggu data di Deferred sampai ada, kita bisa menggunakan
 *   method await().
 */
class AsyncFunction {

    suspend fun getFoo(): Int {
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        return 10
    }

    @Test
    fun testSuspendAsnyc() {
        runBlocking {
            val time = measureTimeMillis {
                val foo: Deferred<Int> = GlobalScope.async { getFoo() }
                val bar: Deferred<Int> = GlobalScope.async { getBar() }
                val total = foo.await() + bar.await()
                println("Total is $total")
            }
            println("Total time $time")
        }
    }

}