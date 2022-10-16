package com.cydeo.user_creation.model;


import com.cydeo.user_creation.enums.Gender;
import com.cydeo.user_creation.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @NotBlank
    @Size(max = 15, min = 2)
    @Pattern(regexp = "[A-Z]\\w*")
    private String firstName;

    @NotBlank
    @Size(max = 15, min = 2)
    @Pattern(regexp = "[A-Z]\\w*")
    private String lastName;

    @Range(max = 120, min = 18)
//    @Max(120)
//    @Min(18)
    private int age;

    @Email
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            message = "Provide a suitable email address ex: michael23jordan23@test.com")
    private String email;

    private Gender gender;

    @NotBlank(message = "address is a required field")
    @Size(max = 100, min = 10)
    private String address;

    private State state;

    private boolean married;

}
