package unit.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void addTest() {
        var result = calculator.add(10, 10);
        assertEquals(20, result);
    }

    @Test
    public void divideTest() {
        Integer result = calculator.divide(10,10);
        assertEquals(1, result);
    }

    @Test
    public void divideTestError() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}

