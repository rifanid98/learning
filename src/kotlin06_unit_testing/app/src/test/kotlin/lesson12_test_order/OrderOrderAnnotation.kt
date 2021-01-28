package lesson12_test_order

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(value = MethodOrderer.OrderAnnotation::class)
class OrderOrderAnnotation {

    @Test
    @Order(1)
    fun run1() {
        println("Test 1")
    }

    @Test
    @Order(2)
    fun run2() {
        println("Test 2")
    }

    @Test
    @Order(3)
    fun run3() {
        println("Test 3")
    }

}