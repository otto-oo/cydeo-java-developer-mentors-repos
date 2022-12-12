package com.builder.basics_1;

import java.util.List;

public class MainBuilder {

    public static void main(String[] args) {
        var student = Student.builder()
                .name("John")
                .surname("Doe")
                .email("email")
                .phoneNumber(123455)
                .year(2)
                .courses(List.of("Java","Spring"))
                .build();

        System.out.println(student);


    }
}
