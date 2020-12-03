package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void beforeSuiteMethod() {
        Configuration.timeout = 15000;
        Configuration.startMaximized = true;
    }
}
