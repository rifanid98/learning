package unit.test.lesson13_test_method_order;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class OrderedDisplayName {

    @Test
    @DisplayName("3")
    public void test1() {

    }

    @Test
    @DisplayName("2")
    public void test3() {

    }

    @Test
    @DisplayName("1")
    public void test2() {

    }
}
