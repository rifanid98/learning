package lesson13_test_lifecycle

import org.junit.jupiter.api.*

/**
 * Siklus Hidup Test
 *
 * - Secara default, lifecycle (siklus hidup) object test adalah independent per
 *   function test, artinya object unit test  akan selalu dibuat baru per function
 *   unit test, oleh karena itu kita tidak bisa bergantung dengan function test
 *   lain.
 * - Cara pembuatan object test di JUnit ditentukan oleh annotation @TestInstance,
 *   dimana defaultnya adalah Lifecycle.PER_METHOD, artinya tiap function akan
 *   dibuat sebuah instance / object baru.
 * - Kita bisa merubahnya menjado Lifecycle.PER_CLASS jika mau, dengan demikian
 *   instance / object test haya dibuat sekali per class, dan function test akan
 *   menggunakan object test yang sama.
 * - Hal ini bisa kita manfaatkan ketika membuat test yang tergantung dengan
 *   test lain .
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation::class)
class TestLifeCycle {

    var count: Int = 0

    @Test
    @AfterEach
    fun showCount() {
        println("count\t: ${this.count}")
    }

    @Test
    @Order(1)
    fun add3() {
        this.count += 3
        Assertions.assertEquals(3, this.count)
    }

    @Test
    @Order(2)
    fun add2() {
        this.count += 2
        Assertions.assertEquals(5, count)
    }

    @Test
    @Order(3)
    fun clear() {
        this.count = 0
        Assertions.assertEquals(0, count)
    }

    /**
     * Keuntungan Instance Per Class
     *
     * - Salah satu keuntungan saat menggunakan Lifecycle.PER_CLASS adalah, kita
     *   bisa menggunakan @BeforeAll dan @AfterAll di function biasa, tidak harus
     *   menggunakan function object  / static.
     */
    @Test
    @BeforeAll
    fun setUp(): Unit {
        println("Sebelum Unit Test")
    }

    @Test
    @AfterAll
    fun tearDown(): Unit {
        println("Setelah Unit Test")
    }

}