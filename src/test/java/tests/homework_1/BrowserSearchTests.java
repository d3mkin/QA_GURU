package tests.homework_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

/**
 * Домашнее задание:
 * 1. Настроить рабочую среду - установить java (jdk8), idea, gradle, git
 * 2. Склонировать репозиторий https://github.com/autotests-cloud/qa_guru_course_2
 * 3. Запустить автотест
 *
 * Расширенное домашнее задание:
 * 4. Написать еще пару тестов на поиск в гугле
 * 5. Написать тест на поиск в яндексе
 */
public class BrowserSearchTests {
    String searchText = "Selenide";
    String searchLink = "https://ru.selenide.org/";

    @Test
    void googleSearchTest() {
        open("https://google.com");
        
        $(byName("q")).setValue(searchText).pressEnter();
        
        $("#search a").shouldHave(attribute("href", searchLink));
    }

    @Test
    void yandexSearchTest() {
        open("https://yandex.ru");
        
        $(byName("text")).setValue(searchText).pressEnter();
        
        $("#search-result a").shouldHave(attribute("href", searchLink));
    }
}
