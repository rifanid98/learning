package unit.test.lesson22_parallel_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelTest {

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    public void slow1() throws InterruptedException {
        Thread.sleep(2_000); // 2 seconds
    }

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    public void slow2() throws InterruptedException {
        Thread.sleep(2_000); // 2 seconds
    }

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    public void slow3() throws InterruptedException {
        Thread.sleep(2_000); // 2 seconds
    }

}
