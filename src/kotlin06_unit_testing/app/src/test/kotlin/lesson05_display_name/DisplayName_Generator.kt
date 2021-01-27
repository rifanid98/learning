package lesson05_display_name

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import java.lang.reflect.Method

/**
 * Menggunakan Display Name Generator
 *
 * - JUnit mendukung pembuatan DisplayName secara otomatis menggunakan generator.
 * - Yang perlu kita lakukan adalah membuat class turunan dari interface
 *   DisplayNameGenerator, lalu menambahkan annotation @DisplayNameGeneration di
 *   test class nya.
 */
class SimpleDisplayNameGenerator: DisplayNameGenerator {

    override fun generateDisplayNameForClass(testClass: Class<*>): String {
        return "Test ${testClass.simpleName}"
    }

    override fun generateDisplayNameForNestedClass(nestedClass: Class<*>): String {
        return "Test ${nestedClass.simpleName}"
    }

    override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String {
        return "Test ${testClass.simpleName}.${testMethod.name}"
    }

}

@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
class DisplayName_Generator {

    @Test
    fun testOne() {
        Assertions.assertEquals(1, 1)
    }

}