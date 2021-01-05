package unit.test.lesson11_enabled_disabled_environment_variable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariables;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

import java.util.Map;

public class EnabledDisabledEnvironmentVariables {

    /**
     * Get System Environment Variables
     */
    @Test
    public void getEnvironmentVariables() {
        Map<String, String> environments = System.getenv();
        environments.forEach((key, value) -> {
            System.out.println("Name \t:" + key);
            System.out.println("Value \t:" + value);
        });
    }

    /**
     * Enabled
     */
    @Test
    @EnabledIfEnvironmentVariables({
        @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV"),
        @EnabledIfEnvironmentVariable(named = "STATUS", matches = "READY")
    })
    public void enabledIfEnvironmentVariables() {
        // code
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "STATUS", matches = "READY")
    public void enabledIfEnvironmentVariable() {
        // code
    }

    /**
     * Disabled
     */
    @Test
    @DisabledIfEnvironmentVariables({
        @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV"),
        @DisabledIfEnvironmentVariable(named = "STATUS", matches = "READY")
    })
    public void disabledIfEnvironmentVariables() {
        // code
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "STATUS", matches = "READY")
    public void disabledIfEnvironmentVariable() {
        // code
    }
}
