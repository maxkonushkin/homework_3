import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;

public class HomeTests extends TestBase{
    Faker faker = new Faker();
    RegistrationPage registrationPage = new RegistrationPage();

    String firstname = faker.name().firstName();
    String lastName = new String("Konushkin");
    String email = new String("myemail@example.com");
    String userNumber = new String("9173173687");
    String currentAddress = new String("proizvodstvennai 13");
    String gender = new String("Male");
    String dateOfBirth1 = new String("11");
    String dateOfBirth2 = new String("July");
    String dateOfBirth3 = new String("1996");
    String uploadPicture = new String("Cat.jpg");
    String subjectsInput = new String("Computer Science");
    String hobbiesWrapper = new String("Sports");
    String state = new String("Haryana");
    String city = new String("Panipat");


    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .hidebanner()
                .setFirstName(firstname)
                .setLastName(lastName)
                .setEmail(email)
                .setUserNumber(userNumber)
                .setCurrentAddress(currentAddress)
                .setGender(gender)
                .setDateOfBirth(dateOfBirth1, dateOfBirth2, dateOfBirth3)
                .setUploadPicture(uploadPicture)
                .setSubjectsInput(subjectsInput)
                .setHobbiesWrapper(hobbiesWrapper)
                .setState(state)
                .setCity(city)
                .setSubmit()
                ;
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
                .setFirstName(firstname)
                .setLastName(lastName)
                .setUserNumber(userNumber)
                .setGender(gender)
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
                .setFirstName(firstname)
                // Проверяем обязательность поля setLastName
                // .setLastName(lastName)
                .setUserNumber(userNumber)
                .setGender(gender)
                .setSubmit()
        ;
        //Проверки:
        registrationPage
                .checkResult("Student Name", "Maks")
        ;

    }
}
