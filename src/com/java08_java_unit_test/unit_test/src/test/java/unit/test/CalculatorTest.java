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
}

