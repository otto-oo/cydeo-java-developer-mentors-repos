package com.cydeo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private Integer id;
    private String Street;
    private String City;
    private String state;
    private String zipCode;
}
