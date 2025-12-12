import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();

    static String firstname = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String email = faker.internet().emailAddress();
    static String currentAddress = faker.address().fullAddress();
    static String phoneNumber = faker.phoneNumber().subscriberNumber(10);

}
