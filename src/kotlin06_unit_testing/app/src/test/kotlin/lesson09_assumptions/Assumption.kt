package lesson09_assumptions

import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.Test
import org.opentest4j.TestAbortedException

/**
 * Assumptions
 *
 * - Sebelumnya kita sudah tahu jika ingin membatalkan test, kita bisa menggunakan
 *   exception TestAbortedException.
 * - Namun sebenarnya ada cara yang lebih mudah, yaitu dengan menggunakan
 *   Assumptions.
 * - Penggunaan Assumptions mirip seperti Assertions, jika nilainya tidak sama,
 *   maka function Assumptions akan thrown TestAbortedException, sehingga secara
 *   otomatis akan membatalkan unit test yang sedang berjalan.
 * - https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assumptions.html.
 */
class Assumption {

    @Test
    fun assumptions() {
        val env: Map<String, String> = System.getenv()
        val profile: String? = env.get("PROFILE");
        val target: String = "development"
        Assumptions.assumeTrue( profile == target)
        println("Development Profile: Test executed!.")
    }

}