package com.builder.methodlevel_3;

import lombok.Builder;

public class ImmutableStudentBuilderClass {



    @Builder(builderMethodName = "myMethodlevelBuilder")
    public static ImmutableStudent newStudent(int id, String name) {
        return new ImmutableStudent(id, name);

    }
}
