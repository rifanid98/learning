package lesson12_test_order

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(value = MethodOrderer.MethodName::class)
class OrderMethodName {

    @Test
    fun run1() {
        println("Test 1")
    }

    @Test
    fun run2() {
        println("Test 2")
    }

    @Test
    fun run3() {
        println("Test 3")
    }

}