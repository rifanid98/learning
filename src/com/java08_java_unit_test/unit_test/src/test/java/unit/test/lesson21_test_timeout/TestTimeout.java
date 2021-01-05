package unit.test.lesson21_test_timeout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TestTimeout {

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    public void slow() throws InterruptedException {
        Thread.sleep(2_000); // 2 seconds
        //Thread.sleep(3_000); // 3 seconds
    }
}
