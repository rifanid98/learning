package part03.lesson25_coroutine_scope_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

/**
 * coroutineScope Function
 *
 * - Kadang pembuatan coroutine scope itu terlalu kompleks jika hanya untuk
 *   kasus-kasus yang sederhana, misal saja kita hanya ingin menggabungkan
 *   beberapa suspend function, lalu mengembalikan nilai tersebut.
 * - Pada kasus yang sederhana, kita bisa menggunakan coroutineScope function
 *   untuk menggabungkan beberapa suspend function.
 * - Saat ada error di coroutine yang terdapat di dalam coroutine scope function
 *   tersebut, maka semua coroutine pun akan dibatalkan.
 */
class CoroutineScopeFunction {

    suspend fun getFoo(): Int {
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        return 10
    }

    suspend fun getSum(): Int = coroutineScope {
        val foo = async { getFoo() }
        val bar = async { getBar() }
        foo.await() + bar.await()
    }

    suspend fun getSumManual(): Int {
        val scope = CoroutineScope(Dispatchers.IO)
        val foo = scope.async { getFoo() }
        val bar = scope.async { getBar() }
        return foo.await() + bar.await()
    }

    @Test
    fun testCoroutineScope() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            val result = getSum()
            println("Result $result")
        }

        runBlocking {
            job.join()
        }
    }

}