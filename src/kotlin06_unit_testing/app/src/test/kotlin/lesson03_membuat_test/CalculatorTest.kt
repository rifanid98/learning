package lesson03_membuat_test

import kotlin06_unit_testing.Calculator
import org.junit.jupiter.api.Test

class CalculatorTest {

    val calculator: Calculator = Calculator()

    @Test
    fun testAddSuccess(): Unit {
        val result = calculator.add(10, 10)
    }

    @Test
    fun testAddSuccess2(): Unit {
        val result = calculator.add(10, 10)
    }

}