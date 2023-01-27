package week_03_generics_enum_lambda_lombok.lombok.withInheritance;


import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
public class Member {

    protected long membershipNumber;
    protected Date membershipStartDate;
}
