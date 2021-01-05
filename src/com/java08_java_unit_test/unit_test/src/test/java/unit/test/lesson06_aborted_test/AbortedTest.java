package unit.test.lesson06_aborted_test;

import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

public class AbortedTest {
    @Test
    public void testAborted() {
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException();
        }
    }
}
