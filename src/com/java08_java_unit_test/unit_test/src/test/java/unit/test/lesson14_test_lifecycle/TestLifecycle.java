package unit.test.lesson14_test_lifecycle;

import org.junit.jupiter.api.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLifecycle {
    private int counter = 0;

    /**
     * Dengan menggunakan TestInstance.Lifecycle.PER_CLASS
     * kita bisa menggunakan @BeforAll dan @AfterAll di
     * method biasa, tidak perlu menggunakan static method.
     */
    @BeforeAll
    public void setUp() {
        System.out.println("before all");
    }

    @AfterAll
    public void tearDown() {
        System.out.println("after all");
    }

    @Test
    @Order(1)
    public void increment() {
        System.out.println("increment()");
        counter+=2;
    }

    @Test
    @Order(2)
    public void decrement() {
        System.out.println("decrement()");
        counter-=1;
    }

    @Test
    @Order(3)
    public void clear() {
        System.out.println("clear()");
        this.counter = 0;
    }

    @AfterEach
    @Disabled
    public void current() {
        System.out.printf("Current Counter %d \n", this.counter);
    }
}
