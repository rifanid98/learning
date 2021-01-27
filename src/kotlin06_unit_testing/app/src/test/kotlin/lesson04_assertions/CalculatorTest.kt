package lesson04_assertions

import kotlin06_unit_testing.Calculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CalculatorTest {

    val calculator: Calculator = Calculator()

    /**
     * Assertions
     *
     * - Saat membuat test, kita harus memastikan bahwa test tersebut sesuai
     *   dengan ekspektasi yang kita inginkan.
     * - Jika manual, kita bisa melakukan pengecekan if else, namun itu tidak
     *   direkomendasikan.
     * - JUnit memiliki fitur untuk melakukan assertions, yaitu memastikan bahwa
     *   unit test sesuai dengan kondisi yang kita inginkan.
     * - Assertions di JUnit di representasikan dalam class Assertions, dan di
     *   dalamnya terdapat banyak sekali function static (di kotlin adalah object
     *   function).
     * - Walaupun JUnit dibuat menggunakan Java, tapi JUnit menyediakan function
     *   khusus untuk Kotlin.
     * - https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html.
     */
    @Test
    fun testAddSuccess(): Unit {
        val result1: Int = calculator.add(10, 10)
        val result2: Int = calculator.add(20, 20)
        Assertions.assertEquals(20, result1)
        Assertions.assertEquals(40, result2, "hasilnya harus 40")
    }

    @Test
    fun testDivideSuccess(): Unit {
        val result: Int = calculator.divide(100, 10)
        Assertions.assertEquals(10, result)
    }

    /**
     * Menggagalkan Test
     *
     * - Kadang dalam membuat unit test, kita tidak hanya ingin mengetest kasus
     *   sukses  atau gagal.
     * - Ada kalanya kita ingin mengetes sebuah exception misalnya.
     * - Assertions juga bisa digunakan untuk mengecek apakah sebuah exception
     *   terjadi.
     */
    @Test
    fun testDivideFailed(): Unit {
        assertThrows<IllegalArgumentException> {
            calculator.divide(100, 0)
        }
    }
}