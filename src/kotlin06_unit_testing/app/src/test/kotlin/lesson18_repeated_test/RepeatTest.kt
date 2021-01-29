package lesson18_repeated_test

import kotlin06_unit_testing.Calculator
import lesson16_dependency_injection.RandomParamResolver
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import java.util.*

/**
 * Test Berulang
 *
 * - JUnit mendukung eksekusi unit test berulang kali sesuai dengan jumlah yang
 *   kita tentukan.
 * - Untuk mengulang eksekusi unit test, kita bisa menggunakan annotation
 *   @RepeatedTest di function unit test nya.
 * - @RepeatedTest juga bisa digunakan untuk mengubah detail nama test nya, dan
 *   kita bisa menggunakan value {displayName} untuk mendapatkan display name,
 *   {currentRepetition} untuk mendapatkan perulangan ke berapa saat ini,  dan
 *   {totalRepetitions} untuk mendapatkan total perulangan nya.
 */
@Extensions(value = [
    ExtendWith(RandomParamResolver::class)
])
abstract class ParentTest {
    val calculator = Calculator()
    @BeforeEach
    fun beforeEach() {
        println("Before Each")
    }
}

class RepeatTest: ParentTest() {

    @DisplayName("Test Berulang")
    @RepeatedTest(
        value = 10,
        name = "{displayName} ke  {currentRepetition} dari {totalRepetitions}"
    )
    fun testRandom(random: Random) {
        val a = random.nextInt()
        val b = random.nextInt()
        Assertions.assertEquals(a+b, this.calculator.add(a, b))
    }

    @DisplayName("Test Berulang Info")
    @RepeatedTest(
        value = 10,
        name = "{displayName} ke  {currentRepetition} dari {totalRepetitions}"
    )
    fun testRandomInfo(random: Random, testInfo: TestInfo, repetitionInfo: RepetitionInfo) {
        println("${testInfo.displayName} ke ${repetitionInfo.currentRepetition} dari ${repetitionInfo.totalRepetitions}")
        val a = random.nextInt()
        val b = random.nextInt()
        Assertions.assertEquals(a+b, this.calculator.add(a, b))
    }

}