package unit.test.lesson15_test_inside_test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class TestInsideTest {
    private Queue<String> queue;

    @Nested
    @DisplayName("When New")
    public class WhenNew {

        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("When offer, size must be 1")
        void name() {
            queue.offer("Adnin");
            Assertions.assertEquals(1, queue.size());
        }
    }
}
