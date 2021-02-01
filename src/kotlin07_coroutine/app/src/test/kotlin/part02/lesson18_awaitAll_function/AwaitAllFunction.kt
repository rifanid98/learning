package part02.lesson18_awaitAll_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * awaitAll Function
 *
 * - Pada materi sebelumnya kita membuat beberapa async coroutine, lalu kita
 *   menggunakan await function untuk menunggu hasil nya.
 * - Pada job, tersedia joinAll untuk menunggu semua launch coroutine selesai.
 * - Kotlin juga menyediakan awaitAll untuk menunggu semua Deferred selesai
 *   mengembalikan value.
 * - awaitAll merupakan generic function, dan mengembalikan List<T> data hasil
 *   dari semua Deffered nya.
 */
class AwaitAllFunction {

    suspend fun getFoo(): Int {
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        return 10
    }

    @Test
    fun testAwaitAll() {
        runBlocking {
            val time = measureTimeMillis {
                val foo: Deferred<Int> = GlobalScope.async { getFoo() }
                val bar: Deferred<Int> = GlobalScope.async { getBar() }
                // pastikan yang di awaitAll tipe datanya sama
                val total = awaitAll(foo, bar).sum()
                println("Total is $total")
            }
            println("Total time $time")
        }
    }

}