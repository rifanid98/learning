package part04.lesson37_mutex

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class MutexTest {

    /**
     * Shared Mutable State
     *
     * - Saat kita belajar Kotlin Collection, kita sudah tau tentang Immutable
     *   dan Mutable.
     * - Saat menggunakan coroutine, sangat disarankan untuk menggunakan data
     *   Immutable, apalagi jika data tersebut di sharing ke beberapa coroutine .
     * - Hal ini agar datanya aman, karena tidak bisa diubah oleh coroutine lain,
     *   jadi tidak akan terjadi problem race condition.
     * - Namun, bagaimana jika ternyata kita memang butuh sharing mutable data di
     *   beberapa coroutine secara sekaligus?
     */
    /**
     * Race Condition
     */
    @Test
    fun testCounter() {
        var counter = 0
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)
        repeat(100) {
            scope.launch { repeat(1000) { counter++ } }
        }
        runBlocking { delay(5_000) }
        println("Total counter : $counter")
    }

    /**
     * Mutex
     *
     * - Mutex (Mutual exclusion) adalah salah satu fitur di Kotlin Coroutine
     *   untuk melakukan proses locking.
     * - Dengan menggunakan mutex, kita bisa pastikan bahwa hanya ada 1 coroutine
     *   yang bisa mengakses kode tersebut, code coroutine yang lain akan menunggu
     *   sampai coroutine pertama selesai.
     */
    @Test
    fun testMutex() {
        var counter = 0
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)
        val mutex = Mutex()
        repeat(100) {
            scope.launch {
                repeat(1000) {
                    mutex.withLock {
                        counter++
                    }
                }
            }
        }
        runBlocking { delay(5_000) }
        println("Total counter : $counter")
    }

}