package com.cydeo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;


@Data
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String fullName;
    private Gender gender;
    private Integer age;
    private Company company;

}
