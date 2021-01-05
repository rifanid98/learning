package unit.test.lesson02_with_generator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import unit.test.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayNameGeneration(value = CalculatorNameGenerator.class)
public class CalculatorTestWithNameGeneration {
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

