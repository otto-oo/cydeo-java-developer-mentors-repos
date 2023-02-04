package week_04_sorting_methodReference_stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static week_04_sorting_methodReference_stream.DataGenerator.*;

class SortingPractice {

    public static void main(String[] args) {
        arrays_collectionsSort();
//        listSort_ascendingOrder();
//        listSort_descendingOrder();
    }

    private static void arrays_collectionsSort() {
        System.out.print(ANSI_BLUE + "Collections.sort() NAMES in ascending order : " + ANSI_RESET);
        Collections.sort(names);
        System.out.println(names);

//        System.out.print(ANSI_BLUE + "Collections.sort() by employee name then age in ascending order : " + ANSI_RESET);
//        Collections.sort(employees);      // it complains if we don't implement Comparable interface at Employee class

        System.out.print(ANSI_BLUE + "Sort array of NAMES in ascending order : " + ANSI_RESET);
        String[] names1 = names.toArray(new String[0]);
        Arrays.sort(names1);
        System.out.println(Arrays.toString(names1));

        System.out.print(ANSI_BLUE + "Sort array of employees by their AGE in ascending order : " + ANSI_RESET);
        Employee[] employees1 = employees.toArray(new Employee[0]);
        Arrays.sort(employees1, Comparator.comparing(e-> e.age));
        System.out.println(Arrays.toString(employees1));
    }

    private static void listSort_ascendingOrder() {
        System.out.print(ANSI_BLUE + "list.sort() by employee NAME in ascending order : " + ANSI_RESET);
        employees.sort(Comparator.comparing(employee -> employee.name));
        employees.forEach(employee -> System.out.print(employee.name + ", "));

        System.out.print(ANSI_BLUE + "list.sort() by employee name in ascending CASE INSENSITIVE order : " + ANSI_RESET);
        employees.sort(Comparator.comparing(employee -> employee.name, String.CASE_INSENSITIVE_ORDER));
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

    private static void listSort_descending_mixedOrder() {
        System.out.println("\n" + ANSI_BLUE + "list.sort() by employee NAME then AGE both in descending order : " + ANSI_RESET);
        employees.sort(
                Comparator.comparing((Employee employee) -> employee.name)
                        .thenComparing(employee -> employee.age)
                        .reversed());
        employees.forEach(employee -> System.out.println(employee.name + ", " + employee.age));

        System.out.println("\n" + ANSI_BLUE + "list.sort() by employee NAME in ascending order then AGE in descending order : " + ANSI_RESET);
        employees.sort(
                Comparator.comparing((Employee employee) -> employee.name)
                        .thenComparing(employee -> employee.age, Comparator.reverseOrder()));
        employees.forEach(employee -> System.out.println(employee.name + ", " + employee.age));

        System.out.println("\n" + ANSI_BLUE + "list.sort() by employee STATE in ascending order, NAME in descending order, AGE in descending order : " + ANSI_RESET);
        employees.sort(
                Comparator.comparing((Employee employee) -> employee.address.getState())
                        .thenComparing( employee -> employee.name, Comparator.reverseOrder())
                        .thenComparing(employee -> employee.age, Comparator.reverseOrder()));
        employees.forEach(employee -> System.out.println(employee.address.getState() + ", " + employee.name + ", " + employee.age));
    }

}
