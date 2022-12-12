package com.builder.withInheritance;


import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
public class Member {

    protected long membershipNumber;
    protected Date membershipStartDate;
}
