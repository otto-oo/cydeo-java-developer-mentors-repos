package week_05_optional_solid_timeComplexity.school_project_template.database;

import com.cydeo.enums.WeekDays;
import week_05_optional_solid_timeComplexity.school_project_template.entity.Course;
import week_05_optional_solid_timeComplexity.school_project_template.entity.Parent;
import week_05_optional_solid_timeComplexity.school_project_template.entity.School;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Course> courseList = new ArrayList<>(List.of(
            new Course(1,"English", 40, List.of(WeekDays.MONDAY, WeekDays.THURSDAY)),
            new Course(2,"Math",50, List.of(WeekDays.values())),
            new Course(3,"Java",80, List.of(WeekDays.WEDNESDAY))
    ));

    public static List<Parent> parentList = new ArrayList<>(List.of(
            new Parent(1,"John", "Wayne", "(212)456-7890)"),
            new Parent(2,"Mike", "Junior", "(416)245-6953)")
    ));

    public static List<Student> studentList = new ArrayList<>(List.of(
            new Student(1,12345L, "Jayne", "Smith", parentList.get(0), courseList ),
            new Student(2, 12346L, "Candy", "Brown", parentList.get(1),courseList )
    ));

    public static List<Teacher> teacherList  = new ArrayList<>(List.of(
            new Teacher(1,"Michael", "Smith", "(212)456-7423)", BigDecimal.valueOf(100000)),
            new Teacher(2,"Mary", "Martinez", "(416)245-6369)", BigDecimal.valueOf(110000))
    ));

    public static List<School> schoolList = new ArrayList<>(List.of(
            new School(1,"ABC_School", studentList,courseList),
            new School(2,"Java_School", studentList,courseList)
    ));




}
