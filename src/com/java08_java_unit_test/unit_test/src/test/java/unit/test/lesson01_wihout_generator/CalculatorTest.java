package unit.test.lesson01_wihout_generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unit.test.Calculator;

@DisplayName("Test Calculator")
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Test Perjumlahan")
    public void addTest() {
        var result = calculator.add(10, 10);
        assertEquals(20, result);
    }

    @Test
    @DisplayName("Test Pembagian")
    public void divideTest() {
        Integer result = calculator.divide(10,10);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Test Pembagian Ketika Error")
    public void divideTestError() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}

