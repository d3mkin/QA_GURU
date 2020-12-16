package tests.homework_7;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * 1. Создайте заново репозиторий с простейшим автотестом (на поиск Selenide в Google)
 * 2. Обменяйтесь ссылками на репозитории в группе.
 * 3. Сделайте pull request в чужой репозиторий - добавьте автотест на поиск в Selenide в Yandex.
 * 4. В ваш репозиторий также придет pull request (если не придет - просто напомните одногрупнику).
 * Сделайте ревью кода (или верните его на доработку, если необходимо) и вмержьте его в свой репозиторий.
 * Для сдачи домашнего задания необходимо:
 * 1. Приложить две ссылки на одобренные pull requests - один в ваш репозиторий и второй вами в чужой.
 * 2. A делает pull request в B, который делает в C, который делает в A.
 * A -> B -> C -> A, другими словами, никаких A <-> B, иначе C
 */

public class CheckPullRequest {

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