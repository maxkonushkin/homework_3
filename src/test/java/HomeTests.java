import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .setFirstName("Maks")
                .setLastName("Konushkin")
                .setEmail("myemail@example.com")
                .setUserNumber("9173173687")
                .setCurrentAddress("proizvodstvennai 13")
                .setGender("Male")
                .setDateOfBirth("11", "July", "1996")
                .setUploadPicture()
                .setSubjectsInput("Computer Science")
                .setHobbiesWrapper("Sports")
                .setState("Haryana")
                .setCity("Panipat")
                .setSubmit()
                ;
        sleep(4000);
        //Проверки:
        registrationPage
                .checkResult("Student Name", "Maks Konushkin")
                .checkResult("Student Email", "myemail@example.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9173173687")
                .checkResult("Date of Birth", "11 July,1996")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Cat.jpg")
                .checkResult("Address", "proizvodstvennai 13")
                .checkResult("State and City", "Haryana Panipat")
        ;

    }

    @Test
    void minFormTest() {

        registrationPage
                .openPage()
                .setFirstName("Maks")
                .setLastName("Konushkin")
                .setUserNumber("9173173687")
                .setGender("Male")
                .setSubmit()
        ;
        //Проверки:
        registrationPage
                .checkResult("Student Name", "Maks Konushkin")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9173173687")
        ;

    }
    @Test
    void negativeFormTest() {

        registrationPage
                .openPage()
                .setFirstName("Maks")
                // Проверяем обязательность поля setLastName
                // .setLastName("Konushkin")
                .setUserNumber("9173173687")
                .setGender("Male")
                .setSubmit()
        ;
        //Проверки:
        registrationPage
                .checkResult("Student Name", "Maks")
        ;

    }
}
