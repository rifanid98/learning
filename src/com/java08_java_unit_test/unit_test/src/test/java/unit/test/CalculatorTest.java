package unit.test;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void addTest() {
        var result = calculator.add(10, 10);
    }
}

