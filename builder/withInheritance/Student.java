package com.builder.withInheritance;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;



@SuperBuilder
@Data
public class Student extends Member {
    private String name;
    private String surname;
    private String email;
    private int year;
    private long phoneNumber;

}
