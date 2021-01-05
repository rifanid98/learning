package unit.test.lesson08_enabled_disabled_on_os;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class EnabledDisabledOnOs {
    @Test
    @EnabledOnOs(value = {OS.WINDOWS})
    public void onlyRunWindows() {
        System.out.println("Run on Windows!");
    }

    @Test
    @EnabledOnOs(value = {OS.LINUX})
    public void onlyRunLinux() {
        System.out.println("Run on Linux!");
    }

    @Test
    @EnabledOnOs(value = {OS.MAC})
    public void onlyRunMacOS() {
        System.out.println("Run on MacOS!");
    }
}
