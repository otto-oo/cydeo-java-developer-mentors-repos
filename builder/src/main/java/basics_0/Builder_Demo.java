package basics_0;

import java.util.Arrays;

public class Builder_Demo {

    public static void main(String[] args) {

        Student student = new StudentBuilder()
                .name("Ower")
                .surname("Any")
                .email("ower@gmail.com")
                .courses(Arrays.asList("English", "French"))
                .year(2002)
                .build();

        System.out.println(student);

        Teacher teacher = Teacher.builder()
                .name("Ozzy")
                .surname("Any")
                .email("ozzy@gmail.com")
                .courses(Arrays.asList("English", "French"))
                .year(2002)
                .build();

        System.out.println(teacher);
    }
}
