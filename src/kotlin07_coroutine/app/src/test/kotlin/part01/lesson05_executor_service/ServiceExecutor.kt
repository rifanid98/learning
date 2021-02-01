package part01.lesson05_executor_service

import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.Executors

/**
 * Masalah dengan Thread
 *
 * - Thread adalah object yang lumayan berat, sekitar 512kb - 1MB, sehingga jika
 *   terlalu banyak membuat Thread, penggunaan memory di aplikasi kita akan
 *   membengkak.
 * - Sehingga penggunaan Thread secara manual sangat tidak disarankan.
 * - Thread sendiri sebenernya bisa digunakan ulang jika proses sudah selesai
 *   dilakukan.
 *
 * ExecutorService
 *
 * - ExecutorService adalah fitur di JVM yang bisa digunakan untuk manajemen
 *   Thread.
 * - Penggunakan ExecutorService lebih direkomendasikan dibandingkan menggunakan
 *   Thread secara manual.
 * - ExecutorService adalah sebuah interface, untuk membuat objectnya, kita bisa
 *   menggunakan class Executors, terdapat banyak helper method di class Executors.
 */
/*
    Executors Method
    ----------------------------------------------------------------------------
    |           Method            |                 Keterangan                 |
    ----------------------------------------------------------------------------
    | newSingleThreadExecutor     | Membuat ExecutorService dengan 1 thread    |
    |--------------------------------------------------------------------------|
    | newFixedThreadPool(int)     | Membuat ExecutorService dengan n thread    |
    |--------------------------------------------------------------------------|
    | newCachedThreadPool()       | Membuat ExecutorService dengan thread akan |
    |                             | meningkat sesuai kebutuhan                 |
    ----------------------------------------------------------------------------
 */
/**
 * Threadpool
 *
 * - Implementasi ExecutorService yang terdapat di class Executors adalah class
 *   ThreadPoolExecutor.
 * - Di dalam ThreadPool, terdapat data queue (antrian) tempat menyimpan semua
 *   proses sebelum di eksekusi oleh Thread yang tersedia di ThreadPool.
 * - Hal ini jadi kita bisa mengeksekusi sebanyak-banyaknya Runnable walaupun
 *   Thread tidak cukup untuk mengeksekusi semua Runnable.
 * - Runnable yang tidak dieksekusi akan menunggu di queue sampai Thread sudah
 *   selesai mengeksekusi Runnable yang lain.
 */
class ServiceExecutor {

    @Test
    fun singleThreadPool() {
        val executor = Executors.newSingleThreadExecutor()
        repeat(10) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executor.execute(runnable)
            println("Selesai memasukkan runnable $it")
        }

        println("Menunggu")
        Thread.sleep(11000)
        println("Selesai Menunggu")
    }

    @Test
    fun fixThreadPool() {
        val executor = Executors.newFixedThreadPool(3)
        repeat(10) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executor.execute(runnable)
            println("Selesai memasukkan runnable $it")
        }

        println("Menunggu")
        Thread.sleep(5000)
        println("Selesai Menunggu")
    }

    @Test
    fun cachedThreadPool() {
        val executor = Executors.newCachedThreadPool()
        repeat(10) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executor.execute(runnable)
            println("Selesai memasukkan runnable $it")
        }

        println("Menunggu")
        Thread.sleep(2000)
        println("Selesai Menunggu")
    }

}