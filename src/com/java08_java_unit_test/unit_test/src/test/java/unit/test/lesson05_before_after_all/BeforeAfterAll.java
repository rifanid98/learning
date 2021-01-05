package unit.test.lesson05_before_after_all;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import unit.test.Calculator;

public class BeforeAfterAll {
    private Calculator calculator = new Calculator();

    /**
     * @BeforeAll dan @AfterAll akan dieksekusi sebelum dan sesudah
     * suatu class test dijalankan.
     */
    @BeforeAll
    public static void setUp() {
        System.out.println("Sebelum Test");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Setelah Test");
    }

    @Test
    public void dummyTest1() {
        System.out.println("dummy test 1");
    }

    @Test
    public void dummyTest2() {
        System.out.println("dummy test 2");
    }
}
