package lesson16_dependency_injection

import kotlin06_unit_testing.Calculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.*
import java.util.Random

/**
 * Dependency Injection di Test
 *
 * - Tidak ada magic di JUnit, sebenarnya fitur TestInfo yang sebelumnya kita
 *   bahas adalah bagian dari dependency injection di JUnit.
 * - Dependency Injection sederhananya adalah bagaimana kita bisa memasukkan
 *   dependency (object/instance) ke dalam unit test secara otomatis tanpa proses
 *   manual.
 * - Saat kita menambah parameter di function unit test, sebenarnya kita bisa
 *   secara otomatis memasukkan parameter tersebut dengan bantuan
 *   ParameterResolver.
 * - Contohnya TestInfo yang kita bahas sebelumya, sebenarnya objectnya dibuat
 *   oleh TestInfoParameterResolver.
 */
class RandomParamResolver: ParameterResolver {

    private val random: Random = Random()

    override fun supportsParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Boolean {
        return parameterContext.parameter.type == Random::class.java
    }

    override fun resolveParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Any {
        return random
    }

}

@Extensions(value =[
    ExtendWith(RandomParamResolver::class)
])
class DependencyInjection {

    private val calculator: Calculator = Calculator()

    @Test
    fun testRandom(random: Random) {
        val first: Int = random.nextInt(1000)
        val second: Int = random.nextInt(1000)

        val result: Int = calculator.add(first, second)
        Assertions.assertEquals(first+second, result)
    }

}