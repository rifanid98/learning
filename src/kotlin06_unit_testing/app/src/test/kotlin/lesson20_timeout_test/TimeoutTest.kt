package lesson20_timeout_test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit

/**
 * Timeout di Test
 *
 * - Kadang kita ingin memastikan bahwa sebuah unit test berjalan tidak lebih dari
 *   sekian detik.
 * - Misal ketika kasus kita ingin memastikan kode program kita mempunyai performa
 *   bagus dan cepat.
 * - JUnit memiliki fitur timeout, yaitu memastikan bahwa unit test berjalan tidak
 *   lebih dari waktu yang ditentukan, jika melebihi waktu yang ditentukan, secara
 *   otomatis unit test tersebut akan gagal.
 * - Kita bisa menggunakan annotation @Timeout untuk melakukan hal tersebut.
 */
class TimeoutTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun slow() {
        Thread.sleep(10_000)
    }
}