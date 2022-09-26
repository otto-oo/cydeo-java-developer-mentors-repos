package com.cydeo.bootstrap;

import com.cydeo.enums.Gender;
import com.cydeo.enums.State;
import com.cydeo.model.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator {

    public static final List<User> USER_LIST = new ArrayList<>();

    public void createUsers() {

        for (int i = 0; i < 10; i++) {
            Gender gender = Gender.FEMALE;
            boolean isMarried = i % 3 == 0 ? true : false;
            if (i % 2 == 0) {
                gender = Gender.MALE;
            }
            State state = State.values()[i];
            USER_LIST.add(new User(new Faker().name().firstName(), new Faker().name().lastName(), new Faker().number().numberBetween(18, 75), gender, new Faker().address().fullAddress(), state, isMarried));
        }
    }

    public void printUsers() {
        USER_LIST.forEach(System.out::println);
    }
}
