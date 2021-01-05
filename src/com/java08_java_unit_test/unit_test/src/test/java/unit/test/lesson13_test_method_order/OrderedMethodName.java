package unit.test.lesson13_test_method_order;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderedMethodName {

    @Test
    public void test1() {

    }
    @Test
    public void test3() {

    }
    @Test
    public void test2() {

    }
}
