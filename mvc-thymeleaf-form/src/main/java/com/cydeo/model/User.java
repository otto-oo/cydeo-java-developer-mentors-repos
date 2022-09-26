package com.cydeo.model;

import com.cydeo.enums.Gender;
import com.cydeo.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String address;
    private State state;
    private boolean married;

}
