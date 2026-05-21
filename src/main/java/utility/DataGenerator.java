package utility;

import com.github.javafaker.Faker;

import javax.swing.plaf.PanelUI;

public class DataGenerator {
    static Faker faker = new Faker();

    public static String generateRandomEmailByTimeStamp(){
        //Get Random Email by TimeStamp
        return "test" + System.currentTimeMillis() + "@gmail.com";
    }

    public static String generateRandomEmail(){
        //Get Random Email by Java Faker
        return faker.internet().emailAddress();
    }

    public static String generateRandomFirstName(){
        return faker.name().firstName();
    }

    public static String generateRandomPassword() {

        return faker.internet().password();
    }
    public static String generateState() {

        return faker.address().state();
    }
    public static String generateCity() {

        return faker.address().city();
    }
    public static String generateZipCode() {

        return faker.address().zipCode();
    }
    public static String generateAddress() {

        return faker.address().fullAddress();
    }
    public static String generateCompany() {

        return faker.company().name();
    }
    public static String generateMobile() {

        return faker.phoneNumber().cellPhone();
    }
    public static String generateNumberBetweenMaxAndMin(int min, int max){

        return String.valueOf(faker.number().numberBetween(min, max));

    }
    public static String generateStringFromList (String... values){

        return faker.options().option(values);



    }

}
