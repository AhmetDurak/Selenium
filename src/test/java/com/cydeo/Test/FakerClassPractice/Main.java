package com.FakerClassPractice;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Main {
    @Test
    public void test1(){
        Faker faker = new Faker();

        String userName = faker.name().fullName();
        String address = faker.address().streetAddress();

        System.out.println(userName);
        System.out.println(address);
        System.out.println(faker.numerify("0176-###-###"));
        System.out.println(faker.bothify("#???#-###"));
        System.out.println(faker.letterify("???-???-###"));

        System.out.println(faker.finance().iban());
        System.out.println(faker.chuckNorris().fact().replaceAll("Chuck Norris","Muhtar"));
    }
}
