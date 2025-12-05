package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String mouth, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__year-select").$(byText("1996")).click();
        $(".react-datepicker__month").$(byText("11")).click();

    }
}