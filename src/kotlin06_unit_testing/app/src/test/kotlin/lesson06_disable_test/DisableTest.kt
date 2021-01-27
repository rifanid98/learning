package lesson06_disable_test

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Menonaktifkan Test
 *
 * - Kadang ada kalanya kita ingin menonaktifkan unit test, misal karena terjadi
 *   error di unit test tersebut, dan belum bisa kita perbaiki.
 * - Sebenarnya cara paling mudah untuk menonaktifkan unit test adalah dengan
 *   menghapus annotation @Test, namun jika kita lakukan itu, kita tidak bisa
 *   mendeteksi kalo ada unit test yang di disabled.
 * - Untuk menonaktifkan unit test secara benar, kita bisa menggunakan annotation
 *   @Disabled.
 */
@DisplayName("Menonaktifkan Test")
class DisableTest {

    @Test
    @DisplayName("Disabled Test")
    @Disabled("Coming Soon")
    fun disableTest() {
        Assertions.assertEquals(1, 1)
    }

}