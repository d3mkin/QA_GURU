package tests.homework_7;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestsForJenkins {
    static Logger logger = LoggerFactory.getLogger(TestsForJenkins.class);

    @Tag("simpleStringTest")
    @Test
    public void stringTest() {
        String a = "Hello, Jenkins!";
        String b = "Hello, Jenkins!";

        assertEquals(a,b, "Hello, Jenkins!");
    }

    @Tag("parameterizedStringTest")
    @Test
    public void parameterizedStringTest() {
        String paramText = System.getProperty("paramText", "Hello, Jenkins!");
        logger.info("\nparamText = " + paramText);

        assertEquals("Hello, Jenkins!", paramText, "text = " + paramText);
    }
}
