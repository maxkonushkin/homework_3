package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            genderWrapper = $("#genterWrapper"),
            uploadPicture = $("#uploadPicture"),
            calendareInput = $("#dateOfBirthInput"),
            hobbiesWrapper = $("#HobbiesWrapper")
             ;

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUploadPicture(){
        uploadPicture.uploadFromClasspath("Cat.jpg");
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String mouth, String year) {
        calendareInput.click();
        calendarComponent.setDate(day, mouth, year);
        return this;
    }
    public RegistrationPage setHobbiesWrapper(){
        $("#hobbiesWrapper").$(byText("Sports")).click();
        return this;
    }
    public RegistrationPage setSubjectsInput(){
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        return this;
    }
    public RegistrationPage setSubmit() {
        $("#submit").click();
        return this;
    }




    //Метод для проверки:
    public RegistrationPage checkResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
