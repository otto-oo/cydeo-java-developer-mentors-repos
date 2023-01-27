package week_03_generics_enum_lambda_lombok.lombok.basics_0.user_demo;

import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Setter // if no Setter, all fields are immutable.
public class User_Lombok {

    private final String firstName;
    private final String lastName;
    private int age;
    private String phone;
    private String address;

}
