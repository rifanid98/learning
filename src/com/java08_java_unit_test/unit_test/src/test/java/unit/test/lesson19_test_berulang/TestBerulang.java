package unit.test.lesson19_test_berulang;

import org.junit.jupiter.api.*;
import unit.test.lesson18_pewarisan.ParentCalculatorTest;

import java.util.Random;

@DisplayName("Test Berulang")
public class TestBerulang extends ParentCalculatorTest {

    @RepeatedTest(
        value = 10,
        /* bisa pakai ini (ditampilkan di tab run sebagai displayName) */
        name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    public void testRandom(Random random, RepetitionInfo repetitionInfo, TestInfo testInfo) {
        /* atau ini (ditampilkan di console) */
        System.out.println(testInfo.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();

        Assertions.assertEquals(a+b, calculator.add(a, b));
    }
}
