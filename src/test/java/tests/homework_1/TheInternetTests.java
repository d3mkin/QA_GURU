package tests.homework_1;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TheInternetTests extends BaseTest {

    @Test
    public void dropDownTest() {
        open("/dropdown");
        $("#dropdown").selectOptionByValue("1");
        $("#dropdown").shouldHave(text("Option 1"));
        $("#dropdown").selectOption("Option 2");
        $("#dropdown").shouldHave(text("Option 2"));
    }

    @Test
    public void alertTest() {
        open("/javascript_alerts");
        $(byText("Click for JS Alert")).click();
        confirm("I am a JS Alert");
        $("#result").should(text("You successfuly clicked an alert"));
        $(byText("Click for JS Confirm")).click();
        confirm("I am a JS Confirm");
        $("#result").should(text("You clicked: Ok"));
        $(byText("Click for JS Confirm")).click();
        dismiss("I am a JS Confirm");
        $("#result").should(text("You clicked: Cancel"));
        $(byText("Click for JS Prompt")).click();
        prompt("SomeText");
        $("#result").should(text("You entered: SomeText"));
        $(byText("Click for JS Prompt")).click();
        dismiss();
        $("#result").should(text("You entered: null"));
    }

    @Test
    public void iFrameTest() {
        open("/iframe");
        switchTo().frame("mce_0_ifr");
        $("#tinymce").setValue("<br><br><h1>Some text!!!</h1>");
    }

    @Test()
    public void waitForTest() {
        open("/dynamic_loading/1");
        $("#start button").shouldBe(visible).click();
        $("#loading").shouldBe(visible);
        $("#finish").shouldBe(visible).shouldHave(text("Hello world!"));
    }

    @Test
    public void checkBoxText() {
        open("/checkboxes");
        $("#checkboxes").$$("input").first().shouldNotBe(checked);
        $("#checkboxes").$$("input").last().shouldBe(checked);
        $("#checkboxes").$$("input").first().click();
        sleep(500);
        $("#checkboxes").$$("input").first().is(not(checked));
    }


}
