package lesson12_test_order

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(value = MethodOrderer.DisplayName::class)
class OrderDisplayName {

    @Test
    @DisplayName("run 1")
    fun run1() {
        println("Test 1")
    }

    @Test
    @DisplayName("run 2")
    fun run2() {
        println("Test 2")
    }

    @Test
    @DisplayName("run 3")
    fun run3() {
        println("Test 3")
    }

}