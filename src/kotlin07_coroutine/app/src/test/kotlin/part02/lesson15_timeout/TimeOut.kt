package part02.lesson15_timeout

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

class TimeOut {

    /**
     * Menggunakan Timeout
     *
     * - Kadang kita ingin sebuah coroutine berjalan tidak lebih dari waktu yang
     *   telah ditentukan.
     * - Sebenarnya kita bisa melakukan hal tersebut secara manual, dengan cara
     *   menjalankan 2 job, dimana job ke dua akan membatalkan job pertama jika
     *   job pertama terlalu lama.
     * - Namun hal ini tidak perlu kita lakukan lagi, terdapat function withTimeout
     *   untuk melakukan hal tersebut..
     * - Jika terjadi timeout melebihi waktu yang telah kita tentukan, maka secara
     *   otomatis function withTimeout akan thro TimeoutCancellationException.
     */
    @Test
    fun testTimeout() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                withTimeout(5000) {
                    delay(1000)
                    println("Timeout ${Date()}")
                }
            }
            job.join()
        }
    }

    /**
     * Timeout Tanpa Membatalkan Coroutine
     *
     * - withTimeout akan throw TimeoutCancellationException, dimana itu adalah
     *   turunan dari CancellationException.
     * - Hal ini berakibat coroutine akan berhenti karena kita throw exception.
     * - Jika ada kasus dimana kita tidak ingin menghentikan coroutine-nya, kita
     *   bisa menggunakan function withTimeoutOrNull, dimana ini tidak akan throw
     *   exception, hanya mengembalikan null jika terjadi timeout.
     */
    @Test
    fun testTimeoutOrNull() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                println("Coroutine Start")
                withTimeoutOrNull(5000) {
                    repeat(50) {
                        delay(1000)
                        println("Timeout ${Date()}")
                    }
                }
                println("Coroutine End")
            }
            job.join()
        }
    }

}