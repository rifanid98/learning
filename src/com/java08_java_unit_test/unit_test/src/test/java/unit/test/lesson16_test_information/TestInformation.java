package unit.test.lesson16_test_information;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("Test Information")
public class TestInformation {

    @Test
    @Tags({
        @Tag("Tag1"),
        @Tag("Tag2")
    })
    @DisplayName("This is test1")
    void test1(TestInfo testInfo) {
        System.out.println("getDisplayName() \t: " + testInfo.getDisplayName());
        System.out.println("getTags() \t\t\t: " + testInfo.getTags());
        System.out.println("getTestClass() \t\t: " + testInfo.getTestClass().orElse(null));
        System.out.println("getTestMethod() \t: " + testInfo.getTestMethod().orElse(null));
    }
}
