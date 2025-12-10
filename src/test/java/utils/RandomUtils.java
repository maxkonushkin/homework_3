package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};
        String randomGender = getRandomItemFromStringArray(genders);

        return randomGender;
    }

    public static String getRandomJpg(){
        String[] Jpeg = {"Cat.jpg", "Dog.jpg"};
        String randomJpeg = getRandomItemFromStringArray(Jpeg);

        return randomJpeg;
    }

    public static String getRandomHobbiesWrapper(){
        String[] hobbiesWrapper = {"Sports", "Reading", "Music"};
        String randomhobbiesWrapper = getRandomItemFromStringArray(hobbiesWrapper);

        return randomhobbiesWrapper;
    }

    public static String getRandomState(){
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        String randomstate = getRandomItemFromStringArray(state);

        return randomstate;
    }


    public static String getRandomSubjectsInput(){
        String[] subjectsInput = {"Physics", "Commerce", "Economics","Computer Science"};
        String randomsubjectsInput = getRandomItemFromStringArray(subjectsInput);

        return randomsubjectsInput;
    }

    public static int getRandomUserNumber(){
        int userNumber = getRandomInt(111111111,999999999);

        return userNumber;
    }

    public static int getRandomDateOfBirth1(){
        int dateOfBirth1 = getRandomInt(1,28);

        return dateOfBirth1;
    }

    public static String getRandomDateOfBirth2(){
        String[] DateOfBirth2 = {"January", "February", "March","April", "May", "June", "July","August",
                "September", "October", "November","December"};
        String randomDateOfBirth2 = getRandomItemFromStringArray(DateOfBirth2);

        return randomDateOfBirth2;
    }

    public static int getRandomDateOfBirth3(){
        int dateOfBirth3 = getRandomInt(1900,2020);

        return dateOfBirth3;
    }

    public static String getRandomItemFromStringArray(String[] stringArray){
        int arrayLength = stringArray.length - 1;
        int randomInt = getRandomInt(0, arrayLength);

        return stringArray[randomInt];
    }
    public static  int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }


}
