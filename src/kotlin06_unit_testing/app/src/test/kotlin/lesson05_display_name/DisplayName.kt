package lesson05_display_name

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Mengubah Nama Test
 *
 * - Kadang agak sulit membuat nama function yang merepresentasikan kasus test
 *   nya.
 * - Jika kita ingin menambahkan deskripsi untuk tiap test, kita bisa menggunakan
 *   annotation @DisplayName.
 * - Dengan menggunakan annotation @DisplayName, kita bisa menambahkan deskripsi
 *   unit testnya.
 */
@DisplayName("Class DisplayName")
class DisplayName {

    @Test
    @DisplayName("Function DisplayName")
    fun testDisplay() {
        Assertions.assertEquals(1, 1)
    }

}