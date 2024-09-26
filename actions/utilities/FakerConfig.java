package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerConfig {
    Faker faker = new Faker(new Locale("US-en"));

    public static FakerConfig getFaker() {
        return new FakerConfig();
    }


    public String firstName() {
        return faker.address().firstName();
    }

    public String lastName() {
        return faker.address().lastName();
    }

    public String emailAddress() {
        return faker.internet().emailAddress();
    }

    public String password() {
        return faker.internet().password();
    }



}
