package tests.homework_1;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Домашнее задание:
 * 1. Установите Git
 * 2. Установите Java
 * 3. Установите Gradle
 * 4. Установите Idea (Community Edition)
 * 5. Скопируйте код из репозитория https://github.com/autotests-cloud/qa_guru_3
 * 6. Запустите автотест.
 * В поле ответа необходимо приложить скриншот пройденного автотеста.
 */

public class GoogleTests {

    @Test
    void selenideSearchTest() {
        // Открыть google
        open("https://google.com");

        // Ввести Selenide в поиск
        $(byName("q")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(Condition.text("selenide.org"));
    }
}