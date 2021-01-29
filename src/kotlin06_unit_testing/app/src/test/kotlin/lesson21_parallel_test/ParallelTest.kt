package lesson21_parallel_test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.util.concurrent.TimeUnit

/**
 * Eksekusi Test Secara Paralel
 *
 * - Secara default, JUnit tidak mendukung eksekusi unit test secara paralel,
 *   artinya unit test akan dijalankan secara sequential satu per satu.
 * - Namun kadang ada kasus kita ingin mempercepat proses unit test sehingga
 *   dijalankan secara paralel, hal ini bisa kita lakukan di JUnit, namun perlu
 *   beberapa langkah.
 * - Tapi ingat, pastikan unit test kita aman ketika dijalankan secara paralel.
 *
 * Menambah Konfigurasi Paralel
 *
 * - Hal pertama yang perlu kita lakukan adalah membuat file
 *   junit-platform.properties di resource.
 * - Lalu menambah value :
 *   > - junit.jupiter.execution.parallel.enabled = true
 *
 * Menggunakan @Execution
 *
 * - Walaupun sudah mengaktifkan fitur paralel, tapi bukan berarti secara otomatis
 *   semua unit test berjalan paralel, agar unit test berjalan paralel, kita perlu
 *   menggunakan annotation @Execution.
 * - Lalu memilih jenis execution nya, misal untuk paralel bisa menggunakan
 *   ExecutionMode.CONCURRENT.
 */
@Execution(value = ExecutionMode.CONCURRENT)
class ParallelTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun test1() {
        Thread.sleep(4_000)
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun test2() {
        Thread.sleep(4_000)
    }

}