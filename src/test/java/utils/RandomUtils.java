package utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    static Faker faker = new Faker();

    public static String getRandomState() {
        return faker.options().option(
                "NCR", "Uttar Pradesh", "Haryana", "Rajasthan"
        );
    }

    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

    public static String getRandomGender() {
        return faker.options().option(
                "Male", "Female", "Other"
        );
    }

    public static String getRandomJpg() {
        return faker.options().option(
                "Cat.jpg", "Dog.jpg"
        );
    }

    public static String getRandomHobbiesWrapper() {
        return faker.options().option(
                "Sports", "Reading", "Music"
        );
    }

    public static String getRandomSubjectsInput() {
        return faker.options().option(
                "Physics", "Commerce", "Economics","Computer Science"
        );
    }

    public static int getRandomDateOfBirth1(){
        return faker.number().numberBetween(10, 28);
    }

    public static String getRandomMonth() {
        return faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
    }

    public static int getRandomDateOfBirth3(){
        return faker.number().numberBetween(1900, 2020);
    }

//    public static String getRandomItemFromStringArray(String[] stringArray){
//        int arrayLength = stringArray.length - 1;
//        int randomInt = getRandomInt(0, arrayLength);
//
 //         return stringArray[randomInt];
//    }
//    public static  int getRandomInt(int min, int max){
//        return ThreadLocalRandom.current().nextInt(min, max + 1);
//    }


}
