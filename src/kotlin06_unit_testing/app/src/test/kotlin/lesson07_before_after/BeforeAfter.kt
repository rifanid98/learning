package lesson07_before_after

import org.junit.jupiter.api.*

@DisplayName("Before & After Each")
class BeforeAfter {

    /**
     * Sebelum & Setelah Semua Unit Test
     *
     * - @BeforeEach & @AfterEach akan dieksekusi setiap kali function @Test jalan.
     * - Namun kadang kita ingin melakukan sesuatu sebelum semua unit test berjalan,
     *   atau setelah semua unit test berjalan.
     * - Ini bisa dilakukan menggunakan annotation @BeforeAll dan @AfterAll.
     * - Namun hanya static function (object function di kotlin) yang bisa menggunakan
     *   @BeforeAll dan @AfterAll.
     */
    companion object {
        @BeforeAll
        @JvmStatic
        fun setUp(): Unit {
            println("Persiapan Awal")
        }

        @AfterAll
        @JvmStatic
        fun tearDown(): Unit {
            println("Persiapan Akhir")
        }
    }

    /**
     * Sebelum & Sedudah Unit Test
     *
     * - Kadang kita ingin menjalankan kode yang sama sebelum dan setelah
     *   eksekusi unit test.
     * - Hal ini sebenarnya bisa dilakukan secara manual di function @Test nya,
     *   namun hal ini akan membuat kode duplikat banyak sekali.
     * - JUnit memiliki annotation @BeforeEach dan @AfterEach.
     * - @BeforeEach digunakan untuk menandai function yang akan dieksekusi
     *   sebelum unit test dijalankan.
     * - @AfterEach digunakan untuk menandai function yang akan dieksekusi setelah
     *   unit teset dijalankan.
     * - Ingat, bahwa ini akan selalu dieksekusi setiap kali untuk function @Test,
     *   bukan sekali untuk class test saja.
     */
    @BeforeEach
    fun beforeEach(): Unit {
        println("Sebelum Unit Test")
    }

    @AfterEach
    fun afterEach(): Unit {
        println("Setelah Unit Test")
    }

    @Test
   fun test1() {
        println("Test 1")
    }

    @Test
    fun test2() {
        println("Test 2")
    }

    @Test
    fun test3() {
        println("Test 3")
    }

    @Test
    fun test4() {
        println("Test 4")
    }

}