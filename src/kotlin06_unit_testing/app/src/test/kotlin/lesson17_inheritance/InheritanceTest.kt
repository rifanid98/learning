package lesson17_inheritance

import kotlin06_unit_testing.Calculator
import lesson16_dependency_injection.RandomParamResolver
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import java.util.*

/**
 * Pewarisan di Test
 *
 * - JUnit mendukung pewarisan di test, artinya jika kita membuat class atau
 *   interface dan menambahkan informasi test disitu, maka ketika kita membuat
 *   turunannya, secara otomatis semua fitur test nya dimiliki oleh turunannya.
 * - Ini sangat cocok ketika kita misal contohnya sering membuat code sebelum dan
 *   setelah test yang berulang-ulang, sehingga dibanding dibuat di semua test
 *   class, lebih baik dibuat sekali di parent test class, dan test class tinggal
 *   menjadi child class dari parent test class.
 */
@Extensions(value = [
    ExtendWith(RandomParamResolver::class)
])
abstract class ParentCalculatorTest {
    val calculator = Calculator()

    @BeforeEach
    fun beforeEach() {
        println("Before Each")
    }
}

class InheritanceTest: ParentCalculatorTest() {

    @Test
    fun testRandom(testInfo: TestInfo, random: Random) {
        val first = random.nextInt(1000)
        val second = random.nextInt(1000)
        val result = this.calculator.add(first, second)
        Assertions.assertEquals(first+second, result)
    }
}