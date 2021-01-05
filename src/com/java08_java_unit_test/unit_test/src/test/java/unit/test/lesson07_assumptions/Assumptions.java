package unit.test.lesson07_assumptions;

import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.Test;

public class Assumptions {
    @Test
    public void testAssumptions() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }
}
