package unit.test.lesson09_enabled_disabled_on_jre;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class EnabledDisabledOnJre {

    /**
     * @EnabledOnJre
     */
    @Test
    @EnabledOnJre(value = {JRE.JAVA_15})
    public void onlyRunOnJava15() {
        System.out.println("Run on JAVA 15!");
    }

    @Test
    @EnabledOnJre(value = {JRE.JAVA_14})
    public void onlyRunOnJava14() {
        System.out.println("Run on JAVA 14!");
    }

    /**
     * @EnabledForJreRange
     */
    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_9)
    public void onlyRunForJava8ToJava9() {
        System.out.println("Run for JAVA 8 to JAVA 9!");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_16)
    public void onlyRunForJava11ToJava16() {
        System.out.println("Run for JAVA 11 to JAVA 16!");
    }
}
