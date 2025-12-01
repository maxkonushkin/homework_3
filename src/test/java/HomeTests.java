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
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 1000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Maks");
        $("#lastName").setValue("Konushkin");
        $("#userEmail").setValue("myemail.com");
        $("#userNumber").setValue("9173173687");
        $("#currentAddress").setValue("proizvodstvennai 13");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__year-select").$(byText("1996")).click();
        $(".react-datepicker__month").$(byText("11")).click();
        $("#genterWrapper").$(byText("Male")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#subjectsContainer").click();
        $("#subjectsContainer").setValue("Maths");
        $("#subjectsContainer").pressEnter();
        sleep(3000);
        $("#subjectsWrapper").click();
        $("#subjectsContainer").setValue("M");

        sleep(3000);
        $("#state").click();
        $("#state").pressEnter();
        sleep(3000);
        $("#subjectsContainer").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("[class=col-md-9 col-sm-12]").setValue("inf");
        sleep(3000);
        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@egorov.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}
