package week_03_generics_enum_lambda_lombok.lombok.basics_0;

import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class Teacher {

    private String name;
    private String surname;
    private String email;
    List<String> courses;
    private int year;
}
