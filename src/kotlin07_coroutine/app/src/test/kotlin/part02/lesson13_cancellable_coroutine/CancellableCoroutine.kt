package part02.lesson13_cancellable_coroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * Membatalkan Coroutine
 *
 * - Sebelumnya kita sudah tahu bahwa Job bisa kita batalkan menggunakan function
 *   cancel.
 * - Membatalkan coroutine kadang diperlukan, misal ketika kode program di
 *   coroutine terlalu lama.
 * - Semua function yang ada di package kotlinx.coroutines bisa dibatalkan.
 * - Namun, jika dalam kode program kita, kita tidak mengecek status cancel, maka
 *   coroutine yang kita buat tidak akan bisa dibatalkan.
 */
class CancellableCoroutine {

    /**
     * Coroutine Tidak Bisa Dibatalkan
     */
    @Test
    fun testCanNotCancel() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                println("Hello ${Date()}")
                Thread.sleep(2000)
                println("World ${Date()}")
            }
            job.cancel()
            job.join()
        }
    }

    /**
     * Membatalkan Coroutine
     *
     * - Untuk mengecek apakah coroutine masih aktif atau tidak (selesai /
     *   dibatalkan), kita bisa menggunakan field isActive milik CoroutineScope.
     * - Untuk menandakan bahwa coroutine dibatalkan, kita bisa throw
     *   CancellationException.
     */
    @Test
    fun testCancelCoroutine() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                if (!isActive) throw CancellationException()
                println("Hello ${Date()}")

                ensureActive()
                Thread.sleep(2000)

                ensureActive()
                println("World ${Date()}")
            }
            job.cancel()
            job.join()
        }
    }

}