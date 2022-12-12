package com.builder.withInheritance;

import java.time.Instant;
import java.util.Date;

public class MainBuilderWithInheritance {
    public static void main(String[] args) {
        var student = Student.builder()
                .name("John")
                .surname("Doe")
                .email("email")
                .phoneNumber(123455)
                .year(2)
                .membershipStartDate(Date.from(Instant.now()))  // comes from parent class
                .membershipNumber(321l)    // comes from parent class
                .build();

        System.out.println(student);
    }

}
