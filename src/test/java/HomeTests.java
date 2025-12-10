import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class HomeTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .hidebanner()
                .setFirstName(TestData.firstname)
                .setLastName(TestData.lastName)
                .setEmail(TestData.email)
                .setUserNumber("7"+RandomUtils.getRandomUserNumber()+ "")
                .setCurrentAddress(TestData.currentAddress)
                .setGender(RandomUtils.getRandomGender())
                .setDateOfBirth(RandomUtils.getRandomDateOfBirth1()+"", RandomUtils.getRandomDateOfBirth2(), RandomUtils.getRandomDateOfBirth3()+"")
                .setUploadPicture(RandomUtils.getRandomJpg())
                .setSubjectsInput(RandomUtils.getRandomSubjectsInput())
                .setHobbiesWrapper(RandomUtils.getRandomHobbiesWrapper())
                .setState(RandomUtils.getRandomState())
                //.setCity(RandomUtils.getRandomCity())
                .setSubmit()
                ;
        //Проверки:
        registrationPage
               // .checkResult("Student Name", "Maks Konushkin")
              //  .checkResult("Student Email", TestData.email)
                .checkResult("Gender", RandomUtils.getRandomGender())
             //   .checkResult("Mobile", "9173173687")
              //  .checkResult("Date of Birth", "11 July,1996")
              //  .checkResult("Subjects", "Computer Science")
               // .checkResult("Hobbies", RandomUtils.getRandomHobbiesWrapper())
               // .checkResult("Picture", RandomUtils.getRandomJpg())
               // .checkResult("Address", TestData.currentAddress)
              //  .checkResult("State and City", "Haryana Panipat")
        ;

    }

    @Test
    void minFormTest() {

        registrationPage
                .openPage()
                .setFirstName(TestData.firstname)
                .setLastName(TestData.lastName)
                .setUserNumber(RandomUtils.getRandomUserNumber()+ "")
                .setGender(RandomUtils.getRandomGender())
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
                .setFirstName(TestData.firstname)
                // Проверяем обязательность поля setLastName
                // .setLastName(lastName)
                .setUserNumber(RandomUtils.getRandomUserNumber()+ "")
                .setGender(RandomUtils.getRandomGender())
                .setSubmit()
        ;
        //Проверки:
        registrationPage
                .checkResult("Student Name", "Maks")
        ;

    }
}
