package part03.lesson26_coroutine_scope_parent_child

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

/**
 * Coroutine Scope Parent & Child
 *
 * - Saat kita membuat sebuah coroutine scope dengan menggunakan function
 *   coroutineScope, sebenarnya kita telah membuat child scope dari parent scope
 *   nya.
 * - Coroutine scope itu saling berkaitan antara parent dan child nya.
 * - Saat kita membuat child scope, secara otomatis child scope akan menggunakan
 *   dispatcher milik parent.
 * - Dan saat kita membatalkan parent scope, maka semua child scope nya pun akan
 *   dibatalkan.
 */
class CoroutineScopeParentChild {

    /**
     * Dispatcher Child Scope
     */
    @Test
    fun testChildDispatcher() {
        val parentDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val parentScope = CoroutineScope(parentDispatcher)
        val job = parentScope.launch {
            println("Parent thread is : ${Thread.currentThread().name}")
            coroutineScope {
                launch {
                    println("Child thread is : ${Thread.currentThread().name}")
                }
            }
        }
        runBlocking {
            job.join()
        }
    }

    /**
     * Membatalkan Parent Scope
     */
    @Test
    fun testCancelParentScope() {
        val parentDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val parentScope = CoroutineScope(parentDispatcher)
        val job = parentScope.launch {
            println("Parent thread is : ${Thread.currentThread().name}")
            coroutineScope {
                launch {
                    println("Child thread is : ${Thread.currentThread().name}")
                }
            }
        }
        runBlocking {
            job.cancelAndJoin()
        }
    }

}