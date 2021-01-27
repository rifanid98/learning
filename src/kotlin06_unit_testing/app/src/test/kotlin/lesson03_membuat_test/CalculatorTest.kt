package lesson03_membuat_test

import kotlin06_unit_testing.Calculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Membuat Test
 *
 * - Untuk membuat test di JUnit itu sederhana, kita cukup membuat class, lalu
 *   menambahkan function-function test nya.
 * - Function akan dianggap sebuah test jika ditambahkan annotation @Test.
 * - Kode test disimpan dibagian test folder di gradle, bukan di main folder.
 * - Biasanya saat membuat class untuk test, rata-rata orang biasa membuat nama
 *   class nya sama dengan nama class yang akan di test, tapi diakhiri dengan
 *   kata Test, misal jika nama class nya adalah Calculator, maka nama class test
 *   nya adalah CalculatorTest.
 */
class CalculatorTest {

    val calculator: Calculator = Calculator()

    @Test
    fun testAddSuccess(): Unit {
        val result = calculator.add(10, 10)
        Assertions.assertEquals(20, result)
    }

    @Test
    fun testAddSuccess2(): Unit {
        val result = calculator.add(10, 10)
        Assertions.assertEquals(20, result)
    }

}