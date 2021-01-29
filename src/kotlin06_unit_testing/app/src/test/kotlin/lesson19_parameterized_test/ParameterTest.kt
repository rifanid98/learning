package lesson19_parameterized_test

import kotlin06_unit_testing.Calculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource


/**
 * Test dengan Parameter
 *
 * - Sebelumnya kita sudah tau jika ingin menambahkan parameter di function unit
 *   test, maka kita perlu membuat ParameterResolver.
 * - Namun jika terlalu banyak membuat ParameterResolver juga agak menyulitkan
 *   kita.
 * - JUnit memiliki fitur yang bernama @ParameterizedTest, dimana jenis unit test
 *   ini memang khusus dibuat agar dapat menerima parameter.
 * - Yang perlu kita lakukan adalah dengan mengganti @Test menjadi
 *   @ParameterizedTest.
 *
 * Sumber Parameter
 *
 * @ParameterizedTest mendukung beberapa sumber parameter, yaitu:
 * - @ValueSource, untuk sumber Number, Char, Boolean dan String.
 * - @EnumSource, untuk sumber berupa enum.
 * - @MethodSource, untuk sumber dari function object (static) .
 * - @CsvSource, untuk sumber beruba data CSV.
 * - @CsvFileSource, untuk sumber beruba file CSV.
 */
class ParameterTest {

    val calculator = Calculator()

    @DisplayName("Parameterized Test: Value Source")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = [10,20,30,40,50])
    fun paramterizedTest(value: Int) {
        println(value)
        val result = this.calculator.add(value, value)
        Assertions.assertEquals(value+value, result)
    }


    companion object {
        @JvmStatic
        fun methodSource(): List<Int> {
            return listOf(1,2,3,4,5)
        }
    }

    @DisplayName("Parameterized Test: Method Source")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @MethodSource(value = ["methodSource"])
    fun paramterizedTest2(value: Int) {
        println(value)
        val result = this.calculator.add(value, value)
        Assertions.assertEquals(value+value, result)
    }

}