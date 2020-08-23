package tests.homework_3;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class AlfaTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void archiveDepositsSizeTest() {
        open("https://alfabank.ru/");

        $(byLinkText("Вклады")).click();
        $(byLinkText("Депозиты")).click();
        $(byLinkText("Архивные депозиты")).click();

        $$(".product-cell__cell").shouldHave(CollectionCondition.size(3));
    }

    @Test
    void depositInsuranceTest() {
        open("https://alfabank.ru/");
        //Клик по Вклады
        $("span.p1Cda9").sibling(0).click();
        //Клик по Страхование вкладов
        $(byTitle("Специальный счет по 44-ФЗ")).parent().preceding(0).click();
        $(".col-xs-offset-2 > h1").shouldHave(text("Страхование вкладов"));
    }
}
