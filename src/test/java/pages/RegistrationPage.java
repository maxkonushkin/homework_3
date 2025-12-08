package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResponsiveComp;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            genderWrapper = $("#genterWrapper"),
            uploadPicture = $("#uploadPicture"),
            calendareInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            submit = $("#submit"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            state = $("#state"),
            city = $("#city")
             ;

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResponsiveComp tableResponsiveComp = new TableResponsiveComp();

    public RegistrationPage openPage(){
        open("/automation-practice-form");

        return this;
    }
    public RegistrationPage hidebanner(){
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
    public RegistrationPage setUploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String mouth, String year) {
        calendareInput.click();
        calendarComponent.setDate(day, mouth, year);
        return this;
    }
    public RegistrationPage setHobbiesWrapper(String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setSubjectsInput(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setSubmit() {
        submit.click();
        return this;
    }
    public RegistrationPage setState(String value) {
        state.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        city.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage checkResult(String key, String value) {

        tableResponsiveComp.setDate(key, value);
        return this;
    }

}
