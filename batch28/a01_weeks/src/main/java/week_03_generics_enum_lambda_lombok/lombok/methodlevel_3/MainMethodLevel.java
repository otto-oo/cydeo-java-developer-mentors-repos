package week_03_generics_enum_lambda_lombok.lombok.methodlevel_3;

public class MainMethodLevel {
    public static void main(String[] args) {
        var is = ImmutableStudentBuilderClass.myMethodlevelBuilder()
                .id(1)
                .name("Student")
                .build();

        System.out.println("is = " + is);
    }
}
