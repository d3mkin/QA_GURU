package tests.homework_2;

import org.junit.jupiter.api.Test;
import tests.BaseTest;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/** Домашнее задание:
 * 1. Перейти на https://demoqa.com/automation-practice-form
 * 2. Написать автотест на проверку данных в форме.
 * 3. Приложить в поле ответа скриншот и код автотеста.
  */

public class FormTests extends BaseTest {
    @Test
    public void fillAllFormTest() {
        //Arrange
        String firstName = "Jack",
                lastName = "Black",
                email = "jb@gmail.com",
                gender = "Male",
                mobileNumber = "9157151515",
                subjects = "Computer Science",
                hobbies = "Sports",
                address = "www.leningrad.spb.ru",
                state = "NCR",
                city = "Delhi";
        File pic = new File("src/test/resources/avatar.jpg");

        //Act
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--021").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(pic);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        //Assert
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $x("*//tr[1]/td[2]").shouldHave(text(firstName + " " + lastName));
        $x("*//tr[2]/td[2]").shouldHave(text(email));
        $x("*//tr[3]/td[2]").shouldHave(text(gender));
        $x("*//tr[4]/td[2]").shouldHave(text(mobileNumber));
        $x("*//tr[5]/td[2]").shouldHave(text("21 May,1990"));
        $x("*//tr[6]/td[2]").shouldHave(text(subjects));
        $x("*//tr[7]/td[2]").shouldHave(text(hobbies));
        $x("*//tr[8]/td[2]").shouldHave(text("avatar.jpg"));
        $x("*//tr[9]/td[2]").shouldHave(text(address));
        $x("*//tr[10]/td[2]").shouldHave(text(state + " " + city));
    }
}
