package unit.test.lesson03_disabled_test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unit.test.Calculator;

public class DisabledTest {
    private Calculator calculator = new Calculator();

    @Test
    @Disabled
    @DisplayName("Test ini diskip dulu")
    public void testComingSoon() {
        // coming soon
    }
}
