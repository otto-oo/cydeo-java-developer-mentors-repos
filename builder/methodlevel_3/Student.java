package com.builder.methodlevel_3;

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

    public Student(String name, String surname, String email, long phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // create instance with default name and surname
    @Builder(builderMethodName = "myMethodlevelBuilder")
    public static Student newTestStudent(String name, String surname) {
        return new Student("DefaultName", "DefaultSurname","email",123l);

    }
}
