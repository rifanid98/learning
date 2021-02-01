package part01.lesson03_membuat_thread

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.concurrent.thread

/**
 * Thread
 *
 * - Kotlin menggunakan Java Thread, sehingga pembuatan Thread di Kotlin sama
 *   seperti pembuatan Thread di Java.
 * - Untuk membuat Thread, kita bisa menggunakan interface Runnable sebagai kode
 *   program yang akan dieksekusi, lalu menggunakan method Thread.start() untuk
 *   menjalankan Thread tersebut.
 * - Ingat, Thread akan berjalan secara paralel, sehingga tidak akan ditunggu oleh
 *   Thread utama.
 * - Kotlin memiliki helper function bernama thread() jika kita ingin membuat
 *   thread lebih singkat dan mudah.
 */
class CreateThread {

    @Test
    fun threadManual() {
        val runnable: Runnable = Runnable {
            println(Date())
            Thread.sleep(2_000)
            println("Hello Thread")
        }

        val thread: Thread = Thread(runnable)
        println("Memulai parallel thread")
        thread.start()

        println("Menunggu semua thread selesai")
        Thread.sleep(3_000)
        println(Date())
        println("Semua thread selesai, selesaikan main thread.")
    }

    @Test
    fun threadAuto() {
        thread(start = true) {
            println(Date())
            Thread.sleep(2000)
            println("Parallel thread selesai")
        }

        println("Menunggu semua thread selesai")
        Thread.sleep(3000)
        println("Semua thread selesai, selesaikan main thread.")
    }
}