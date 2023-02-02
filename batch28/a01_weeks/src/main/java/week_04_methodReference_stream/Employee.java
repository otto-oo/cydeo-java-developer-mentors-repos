package week_04_methodReference_stream;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Setter
@ToString
class Employee {
//        implements Comparable<Employee> {

    String name;
    Integer age;
    List<String> children;
    Address address;

    public Employee(String name, Integer age, List<String> children) {
        this.name = name;
        this.age = age;
        this.children = children;
    }

//    @Override
//    public int compareTo(Employee o) {
//        int n = name.compareTo(o.name);
//        return n != 0 ? n : age.compareTo(o.age);
//    }


    /** we need to override equals & hashCode methods to be able to use distinct() of Stream */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

