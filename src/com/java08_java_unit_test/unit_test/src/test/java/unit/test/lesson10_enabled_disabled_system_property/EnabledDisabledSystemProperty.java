package unit.test.lesson10_enabled_disabled_system_property;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.util.Properties;

public class EnabledDisabledSystemProperty {

    /**
     * Get system properties
     */
    @Test
    public void getSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> {
            System.out.println("Name \t:" + key);
            System.out.println("Value \t:" + value);
        });
    }

    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void enabledOnOracle() {
        // oracle
    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void enabledOnOpenJDK() {
        // open jdk
    }
}
