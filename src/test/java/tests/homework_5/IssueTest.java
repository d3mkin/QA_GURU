package tests.homework_5;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

/**
 * Домашнее задание:
 *Написать тест на создание Issue в репозитории через Web-интерфейс.
 * 1. Название Issue
 * 2. На кого назначена
 * 3. Теги Isssue
 *
 * Этот тест представить в трех вариантах:
 * 1. Чистый Selenide
 * 2. Лямбда шаги через step (name, () -> {})
 * 3. Шаги с аннотацией @Step
 * В качестве ответа на задание приложите скриншот с кодом в поле ответа
 */

@Feature("Работа с задачами")
public class IssueTest {

    private static final String REPOSITORY = "d3mkin/QA_GURU";
    private static final String URL = "https://github.com";
    private static final String LOGIN = "bro.d3mk@gmail.com";
    private static final String PASS = "ChillMyBones12345!";
    private static final String TITLE = "Test-Title";
    private static final String LABEL = "bug";

    @Test
    @Owner("Demian")
    @DisplayName("Пользователь может создать Issue")
    public void shouldCreateIssue () {
        parameter("Рерозиторий", REPOSITORY);
        parameter("URL", URL);
        parameter("Логин", LOGIN);
        parameter("Пароль", PASS);
        parameter("Заголовок", TITLE);
        parameter("Тег", LABEL);

        step("Открываем URL " + URL, () -> open (URL));
        step("Логинимся", () -> {
            $(byText("Sign in")).click();
            $("#login_field").setValue(LOGIN);
            $("#password").setValue(PASS).pressEnter();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
            $(byLinkText(REPOSITORY)).click();
        });
        step("Заводим Issue на текущего пользователя c заголовком: " + TITLE
                + " и тегом: " + LABEL, () -> {
            $("a[data-tab-item='issues-tab']").click();
            $(".btn-primary span").click();

            $("#issue_title").setValue(TITLE);

            $("#assignees-select-menu").click();
            $(".js-username").click();
            $("body").click();

            $("#labels-select-menu").click();
            $(withText(LABEL)).click();
            $("body").click();
            $(withText("Submit new issue")).click();
        });
    }
}
