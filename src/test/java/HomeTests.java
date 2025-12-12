
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class HomeTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    String gender = RandomUtils.getRandomGender();
    String dateOfBirth1 = RandomUtils.getRandomDateOfBirth1()+"";
    String dateOfBirth2 = RandomUtils.getRandomMonth();
    String dateOfBirth3 = RandomUtils.getRandomDateOfBirth3()+"";
    String uploadPicture = RandomUtils.getRandomJpg();
    String subjectsInput = RandomUtils.getRandomSubjectsInput();
    String hobbiesWrapper = RandomUtils.getRandomHobbiesWrapper();
    String state = RandomUtils.getRandomState();
    String сity = RandomUtils.getRandomCity(state);

    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .hidebanner()
                .setFirstName(TestData.firstname)
                .setLastName(TestData.lastName)
                .setEmail(TestData.email)
                .setCurrentAddress(TestData.currentAddress)
                .setGender(gender)
                .setDateOfBirth(dateOfBirth1, dateOfBirth2, dateOfBirth3)
                .setUserNumber(TestData.phoneNumber)
                .setUploadPicture(uploadPicture)
                .setSubjectsInput(subjectsInput)
                .setHobbiesWrapper(hobbiesWrapper)
                .setState(state)
                .setCity(сity)
                .setSubmit()
                ;

        //Проверки:
        registrationPage
                .checkResult("Student Name", TestData.firstname +" " +TestData.lastName)
                .checkResult("Student Email", TestData.email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", TestData.phoneNumber)
                .checkResult("Date of Birth", dateOfBirth1 + " "+ dateOfBirth2 + "," + dateOfBirth3)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Hobbies", hobbiesWrapper)
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", TestData.currentAddress)
                .checkResult("State and City", state + " " + сity)
        ;

    }

    @Test
    void minFormTest() {

        registrationPage
                .openPage()
                .setFirstName(TestData.firstname)
                .setLastName(TestData.lastName)
                .setUserNumber(TestData.phoneNumber)
                .setGender(gender)
                .setSubmit()
        ;
        //Проверки:
        registrationPage
                .checkResult("Student Name", TestData.firstname +" " +TestData.lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", TestData.phoneNumber)
        ;

    }
    @Test
    void negativeFormTest() {

        registrationPage
                .openPage()
                .setFirstName(TestData.firstname)
                // Проверяем обязательность поля setLastName
                // .setLastName(lastName)
                .setUserNumber(TestData.phoneNumber)
                .setGender(gender)
                .setSubmit()
        ;
        //Проверки:
        registrationPage
                .checkResult("Student Name", TestData.firstname)
        ;

    }
}
