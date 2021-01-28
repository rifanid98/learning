package lesson10_condition_test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.*

/**
 * Test Berdasarkan Kondisi
 *
 * - Sebenarnya kita bisa menggunakan Assumptions untuk menjalankan unit test
 *   berdasarkan kondisi tertentu.
 * - Namun JUnit menyediakan fitur yang lebih mudah untuk pengecekan beberapa
 *   kondisi, seperti kondisi sistem operasi, versi java, system property atau
 *   environment variable.
 * - Ini lebih mudah  dibandingkan menggunakan Assumptions.
 */
@DisplayName("Test by Condition")
class ConditionTest {

    /**
     * Kondisi OS
     *
     * - Untuk kondisi sistem operasi, kita bisa menggunakan beberapa annotation.
     * - @EnabledOnOs digunakan untuk penanda bahwa unit test boleh berjalan di
     *   sistem operasi yang ditentukan.
     * - @DisabledOnOs digunakan untuk penanda bahwa unit test tidak boleh berjalan
     *   di sistem operasi yang ditentukan.
     */
    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Enabled on Windows OS")
    fun enableOnWindows() {
        println("run on linux, but not on linux and mac.")
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    @DisplayName("Disabled on Windows OS")
    fun disableOnWindows() {
        println("run on linux, mac but not on windows")
    }

    @Test
    @EnabledOnOs(value = [OS.WINDOWS, OS.LINUX, OS.MAC])
    @DisplayName("Disabled on Windows OS")
    fun enableOnSomeOS() {
        println("run on some os")
    }

    /**
     * Kondisi Versi Java
     *
     * - Untuk kondisi versi Java yang kita gunakan, kita bisa menggunakan
     *   beberapa annotation.
     * - @EnabledOnJre digunakan untuk penanda bahwa unit test boleh berjalan
     *   di Java versi tertentu.
     * - @DisabledOnJre digunakan untuk penanda bahwa unit test tidak boleh
     *   berjalan di Java versi tertentu.
     * - @EnabledForJreRange digunakan untuk penanda bahwa unit test boleh
     *   berjalan di range Java versi tertentu.
     * - @DisabledForJreRange digunakan untuk penanda bahwa unit test tidak
     *   boleh berjalan di range Java versi tertentu.
     */
    @Test
    @EnabledOnJre(JRE.JAVA_15)
    @DisplayName("Enabled on JAVA 15")
    fun enabledOnJava15() {
        println("Enabled on JAva 15 Only")
    }

    @Test
    @DisabledOnJre(JRE.JAVA_16)
    @DisplayName("Disabled on JAVA 16")
    fun disabledOnJava16() {
        println("Executed on Java < 16 & Java > 16, but not executed on JAVA 16")
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_16)
    @DisplayName("Enabled on Java 8 ~ Java 16")
    fun enabledOnJavaRange() {
        println("This test executed on some jre.")
    }

    /**
     * Kondisi System Property
     *
     * - Untuk kondisi nilai dari system property, kita bisa menggunakan
     *   beberapa annotation.
     * - @EnabledIfSystemProperty untuk penanda bahwa unit test boleh berjalan
     *   jika system property sesuai dengan yang ditentukan.
     * - @DisabledIfSystemProperty untuk penanda bahwa unit test tidak boleh
     *   berjalan jika system property sesuai dengan yang ditentukan.
     * - Jika kondisinya lebih dari satu, kita bisa menggunakan
     *   @EnabledIfSystemProperties dan @DisabledIfSystemProperties.
     */
    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    fun enabledOnOracle() {
//        val properties: Properties = System.getProperties()
//        properties.forEach { (key, value) ->
//            println("$key : $value")
//        }
        println("run on oracle jdk")
    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    fun disabledOnOracle() {
        println("disabled on oracle jdk")
    }

    @Test
    @EnabledIfSystemProperties(value = [
        EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation"),
        EnabledIfSystemProperty(named = "java.vendor", matches = "Other Corporation")
    ])
    fun enabledOnSomeJDK() {
        println("enabled on some jdk")
    }

    /**
     * Kondisi Environment Variable
     *
     * - Untuk kondisi nilai dari environment variable, kita bisa menggunakan
     *   beberapa annotation.
     * - @EnabledIfEnvironmentVariable untuk penanda bahwa unit test boleh
     *   berjalan jika environment variable sesuai dengan yang ditentukan.
     * - @DisabledIfEnvironmentVariable untuk penanda bahwa unit test tidak
     *   boleh berjalan jika environment variable sesuai dengan yang ditentukan.
     * - Jika kondisinya lebih dari satu, kita bisa menggunakan
     *   @EnabledIfEnvironmentVariables dan @DisabledIfEnvironmentVariables.
     */
    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "development")
    fun enabledOnDevelopment() {
        println("run on development profile")
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "production")
    fun disabledOnProduction() {
        println("not run on production, run on development")
    }

    @Test
    @EnabledIfEnvironmentVariables(value = [
        EnabledIfEnvironmentVariable(named = "PROFILE", matches = "production"),
        EnabledIfEnvironmentVariable(named = "PROFILE", matches = "development")
    ])
    fun enabledOnSomeEnvironment() {
        println("run on production and development")
    }
}