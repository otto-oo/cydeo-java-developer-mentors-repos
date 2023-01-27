package week_03_generics_enum_lambda_lombok.lombok.basics_0;

import java.util.List;

public class Student {

    private String name;
    private String surname;
    private String email;
    List<String> courses;
    private int year;

    public Student(String name, String surname, String email, List<String> courses, int year) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.courses = courses;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", courses=" + courses +
                ", year=" + year +
                '}';
    }
}
