package com.builder.basics_1;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
class Student {


   private String name;
   private String surname;
   private String email;
   List<String> courses;
   private int year;
   private long phoneNumber;

}
