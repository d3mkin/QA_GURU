package tests.homework_7;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1. Зарегистрироваться в Jenkins https://jenkins.autotests.cloud/
 * 2. Написать простейший автотест и добиться чтобы можно было запустить тесты из терминала командой типа "gradle some_tests"
 * 3. Сделать джобу в дженкинсе:
 * - Указать в настройках джобы ссылку на свой гитхаб-проект
 * - Указать команду для запуска.
 * 4. Добавьте в код автотестов возможность передавать параметр из терминала
 * 5. И добавьте в вашу джобу в jenkins возможнось передавать параметр в запуск тестов
 */

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
