package unit.test.lesson18_pewarisan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import unit.test.Calculator;
import unit.test.lesson17_dependency_injection.RandomParameterResolver;

@Extensions(value = {@ExtendWith({RandomParameterResolver.class})})
public class ParentCalculatorTest {

    protected Calculator calculator = new Calculator();

    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }
}
