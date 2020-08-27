package tests.homework_7;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestsForJenkins {
    @Tag("stringTest")
    @Test
    public void StringTest() {
        String a = "Hello, Jenkins!";
        String b = "Hello, Jenkins!";

        assert(a.equals(b));
    }
}
