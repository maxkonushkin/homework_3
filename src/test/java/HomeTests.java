import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 1000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Maks");
        $("#lastName").setValue("Konushkin");
        $("#userEmail").setValue("myemail@example.com");
        $("#userNumber").setValue("9173173687");
        $("#currentAddress").setValue("proizvodstvennai 13");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__year-select").$(byText("1996")).click();
        $(".react-datepicker__month").$(byText("11")).click();
        $("#genterWrapper").$(byText("Male")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#uploadPicture").uploadFromClasspath("Cat.jpg");
        $("#submit").click();
        //Проверки:
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Maks Konushkin"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("myemail@example.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9173173687"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("11 July,1996"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths, Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Cat.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("proizvodstvennai 13"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Panipat"));
    }
}
