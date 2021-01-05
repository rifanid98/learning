package unit.test.lesson20_parameterized_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import unit.test.lesson18_pewarisan.ParentCalculatorTest;

import java.util.List;

public class TestWithParameter extends ParentCalculatorTest {

    public void test(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);
        Assertions.assertEquals(expected, result);
    }

    /**
     * Sumber parameter yang didukung:
     *
     * - @ValueSource, untuk sumber parameter berupa tipe data biasa atau basic.
     * - @EnumSource, untuk sumber parameter berupa tipe data Enum.
     * - @MethodSource, untuk sumber parameter berupa static method.
     * - @CsvSource, untuk sumber parameter berupa data CSV.
     * - @CsvFileSource, untuk sumber parameter berupa file CSV.
     * - @ArgumentSource, untuk sumber parameter berupa data dari class ArgumentProvider.
     */
    /* Test with @ValueSource */
    @DisplayName("Test Calculator with Parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5}) // data ini akan diloop
    public void testWithParameter(int value) {
        test(value);
    }

    /* Test with @MethodSource */
    public static List<Integer> parameterSource() {
        return List.of(1,2,3,4,5);
    }

    @DisplayName("Test Calculator with Parameter (MethodSource)")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @MethodSource(value = "{parameterSource}")
    public void testWithParameter2(int value) {
        test(value);
    }
}
