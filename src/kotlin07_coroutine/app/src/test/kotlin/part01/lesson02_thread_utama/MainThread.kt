package part01.lesson02_thread_utama

import org.junit.jupiter.api.Test

/**
 * Thread Utama
 *
 * - Saat kita menjalankan sebuah process (aplikasi) Kotlin di JVM, secara
 *   otomatis proses tersebut akan jalan di sebuah thread utama.
 * - Thread utama tersebut bernama main thread (JVM).
 * - Saat kita menjalankan process JUnit, JUnit pun berjalan di thread tersendiri.
 * - Begitu juga jika kita  membuat aplikasi kotlin Android, aplikasi tersebut
 *   akan berjalan di sebuah thread .
 */
class MainThread  {

    @Test
    fun testThreadName() {
        val threadName: String = Thread.currentThread().name
        println(threadName)
    }

}


fun main() {
    val threadName: String = Thread.currentThread().name
    println(threadName)
}