package tests.homework_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Configuration.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;


public class BrowserSearchTests {
    String searchText = "Selenide";
    String searchLink = "https://ru.selenide.org/";

    @Test
    void GoogleSearchTest() {
        open("https://google.com");
        $(byName("q")).setValue(searchText).pressEnter();
        $("#search a").shouldBe(visible).shouldHave(attribute("href", searchLink));
    }

    @Test
    void  YandexSearchTest() {
        open("https://yandex.ru");
        $(byName("text")).setValue(searchText).pressEnter();
        $("#search-result a").shouldBe(visible).shouldHave(attribute("href", searchLink));
    }
}
