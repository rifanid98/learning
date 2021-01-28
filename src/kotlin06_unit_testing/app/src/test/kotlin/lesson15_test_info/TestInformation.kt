package lesson15_test_info

import org.junit.jupiter.api.*

/**
 * Informasi Test
 *
 * - Walaupun mungkin jarang kita gunakan, tapi kita juga bisa mendapatkan
 *   informasi test yang sedang berjalan menggunakan interface TestInfo.
 * - Kita bisa menambahkan TestInfo sebagai parameter di function unit test.
 */
@DisplayName("Informasi Test")
class TestInformation {

    @Test
    @Tags(value = [
        Tag("sample1"),
        Tag("sample2")
    ])
    @DisplayName("Sample Test")
    fun sampleTest(testInfo: TestInfo): Unit {
        println("testInfo.displayName: ${testInfo.displayName}")
        println("testInfo.tags\t\t: ${testInfo.tags}")
        println("testInfo.testClass\t: ${testInfo.testClass}")
        println("testInfo.testMethod\t: ${testInfo.testMethod}")
    }

}