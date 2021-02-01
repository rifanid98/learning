package part01.lesson09_coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Membuat Coroutine
 *
 * - Coroutine tidak bisa berjalan sendiri, dia perlu berjalan di dalam sebuah
 *   Scope.
 * - Salah satu scope yang bisa kita gunakan adalah GlobalScope (masih banyak
 *   scope yang ada, dan akan kita bahas nanti dimateri tersendiri).
 * - Untuk membuat coroutine, kita bisa menggunakan method launch().
 * - Dan di dalam coroutine, kita bisa memanggil suspend function.
 */
class CoroutineClass {

    suspend fun world() {
        delay(1000)
        println("World")
    }

    @Test
    fun testCoroutine() {
        GlobalScope.launch {
            world()
        }
        println("Menunggu")
        runBlocking {
            delay(2000)
        }
        println("Selesai")
    }

}