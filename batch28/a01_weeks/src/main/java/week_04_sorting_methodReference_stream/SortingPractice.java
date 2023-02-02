package week_04_sorting_methodReference_stream;

import java.util.Collections;
import java.util.Comparator;

import static week_04_sorting_methodReference_stream.DataGenerator.*;

public class SortingPractice {

    public static void main(String[] args) {
        collectionsSort();
        listSort_ascendingOrder();
        listSort_descendingOrder();
    }

    private static void collectionsSort(){
        System.out.print(ANSI_BLUE + "Collections.sort() names in ascending order : " + ANSI_RESET);
        Collections.sort(names);
        System.out.println(names);

//        System.out.print(ANSI_BLUE + "Collections.sort() by employee name then age in ascending order : " + ANSI_RESET);
//        Collections.sort(employees);
    }

    private static void listSort_ascendingOrder(){
        System.out.print(ANSI_BLUE + "list.sort() by employee name in ascending order : " + ANSI_RESET);
        employees.sort(Comparator.comparing(employee -> employee.name));
        employees.forEach(employee -> System.out.print(employee.name + ", "));

        System.out.println("\n" + ANSI_BLUE + "list.sort() by employee NAME then AGE in ascending order : " + ANSI_RESET);
        employees.sort(
                Comparator.comparing((Employee employee) -> employee.name)
                        .thenComparing(employee -> employee.age));
        employees.forEach(employee -> System.out.println(employee.name + ", " + employee.age));

        System.out.println("\n" + ANSI_BLUE + "list.sort() by employee STATE then NAME then AGE in ascending order : " + ANSI_RESET);
        employees.sort(
                Comparator.comparing((Employee employee) -> employee.address.getState())
                        .thenComparing(employee -> employee.name)
                        .thenComparing(employee -> employee.age));
        employees.forEach(employee -> System.out.println(employee.address.getState() + ", " + employee.name + ", " + employee.age));
    }

    private static void listSort_descendingOrder(){
        System.out.println("\n" + ANSI_BLUE + "list.sort() by employee name then age both in descending order : " + ANSI_RESET);
        employees.sort(
                Comparator.comparing((Employee employee) -> employee.name)
                        .thenComparing(employee -> employee.age)
                        .reversed());
        employees.forEach(employee -> System.out.println(employee.name + ", " + employee.age));

        System.out.println("\n" + ANSI_BLUE + "list.sort() by employee name in ascending order then age in descending order : " + ANSI_RESET);
        employees.sort(
                Comparator.comparing((Employee employee) -> employee.name)
                        .thenComparing(employee -> employee.age, Comparator.reverseOrder()));
        employees.forEach(employee -> System.out.println(employee.name + ", " + employee.age));

        System.out.println("\n" + ANSI_BLUE + "list.sort() by employee name in descending order then age in descending order : " + ANSI_RESET);
        employees.sort(
                Comparator.comparing((Employee employee) -> employee.name, Comparator.reverseOrder())
                        .thenComparing(employee -> employee.age, Comparator.reverseOrder()));
        employees.forEach(employee -> System.out.println(employee.name + ", " + employee.age));
    }

}
