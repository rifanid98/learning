package lesson08_abort_test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.opentest4j.TestAbortedException

/**
 * Membatalkan Test
 *
 * - Kadang kita ingin membatalkan unit test ketika kondisi tertentu terjadi.
 * - Untuk membatalkan, kita bisa menggunakan exception TestAbortedException.
 * - Jika JUnit mendapatkan exception TestAbortedException, secara otomatis test \
 *   tersebut akan dibatalkan.
 */
@DisplayName("Aborted Test")
class AbortTest {

    @Test
    fun testAborted() {
        val env: Map<String, String> = System.getenv()
        val target: String = "production"
        if (env.get("PROFILE") != target) {
            throw TestAbortedException()
        }
        println("Test executed")
    }

}