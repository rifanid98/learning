package unit.test.lesson18_pewarisan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class ChildCalculatorTest extends ParentCalculatorTest {

    @Test
    public void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        Assertions.assertEquals(a+b, calculator.add(a, b));
    }
}
