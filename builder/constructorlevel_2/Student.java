package com.builder.constructorlevel_2;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
 class Student {

    private String name;
    private String surname;
    private String email;
    List<String> courses;
    private int year;
    private long phoneNumber;

    @Builder
    public Student(String name, String surname, String email, long phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
