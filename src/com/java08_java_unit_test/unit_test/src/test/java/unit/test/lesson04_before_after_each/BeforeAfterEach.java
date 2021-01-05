package unit.test.lesson04_before_after_each;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.test.Calculator;

public class BeforeAfterEach {
    private Calculator calculator = new Calculator();

    /**
     * @BeforeEach dan @AfterEach akan dieksekusi untuk setiap
     * @Test dijalankan. Jadi jika ada 10 method dengan @Test
     * yang enable, maka akan dieksekusi 10 kali @BeforeEach dan
     * @AfterEach
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Sebelum Test");
    }

    @AfterEach
    public void tearDown() {
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
