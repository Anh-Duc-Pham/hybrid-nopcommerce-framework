package com.java;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Topic_01_Faker {
    public static void main(String[] args) {
        Faker faker =new Faker(new Locale("en-US"));
        System.out.println(faker.address().firstName());
        System.out.println(faker.address().lastName());
        System.out.println(faker.address().city());
        System.out.println(faker.address().state());
        System.out.println(faker.address().zipCode());
        System.out.println(faker.internet().domainName());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().password());
        System.out.println(faker.internet().ipV4Address());
        System.out.println(faker.internet().password(6, 12));
        System.out.println(faker.internet().password(6, 12, true));
        System.out.println(faker.internet().password(6, 12, true ,true));

    }
}
