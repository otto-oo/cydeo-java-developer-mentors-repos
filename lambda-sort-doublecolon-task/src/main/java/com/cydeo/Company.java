package com.cydeo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Company {

    private Integer id;
    private String companyName;
    private Address address;
}
