package week_04_methodReference_stream;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {

        //
//        Map<String, Integer> allUserMap = Map.of("Marry", 55, "Gerard", 47, "Terry", 23);
//        List<String> allInStringList = allUserMap.entrySet().stream()
//                .filter(user -> user.getValue() > 20)
//                .map(user -> user.getKey() + ": " + user.getValue() + " years old")
//                .collect(Collectors.toList());
//        System.out.println(allInStringList);
//
//
////        List<Employee> employees = new ArrayList<>(Arrays.asList(
////                new Employee("Henry", 45, Arrays.asList("Mike j.", "Anna", "Tim")),
////                new Employee("Michael", 29, Arrays.asList("Sue", "Tim")),
////                new Employee("Garry", 50, Arrays.asList("Mich", "Sharon"))));
////        boolean isNoneMatch = employees.stream().noneMatch(employee -> employee.age > 55);
////        System.out.println(isNoneMatch);
//
//        List<String> names = Arrays.asList("John", "Barry", "Chris", "John", "Chris", "Marry", "Paul");
//        Map<String, Integer> namesInMap = names.stream()
//                .distinct()
//                .collect(Collectors.toMap(Function.identity(), String::length));
//        //.collect(Collectors.toMap(n -> n, String::length));
//        System.out.println(namesInMap);
//
//        Map<Integer, List<String>> namesInMap2 = employees.stream()
//                .distinct()
//                .collect(Collectors.toMap(employee -> employee.age, e -> e.children));
//        System.out.println("namesInMap2 = " + namesInMap2);
//
//        Map<String, Integer> namesInMap3 = employees.stream()
//                .collect(Collectors.toMap(employee -> employee.name, e -> e.children.size()));
//        System.out.println("namesInMap3 = " + namesInMap3);
//
//        List<String> names2 =
//                Arrays.asList("John", "Barry");
//        // Integer sumOfLengths = names2.stream().collect(Collectors.summingInt(String::length));
//        Integer sumOfLengths = names2.stream().mapToInt(String::length).sum();
//        System.out.println(sumOfLengths);
//
//        List<String> names3 = Arrays.asList("John", "Barry");
//        double averageOfLengths = names3.stream()
//                //       .collect(Collectors.averagingInt(name -> name.length()));
//                //.collect(Collectors.averagingInt(String::length));    same
//                .mapToInt(String::length).average().orElse(Double.MIN_NORMAL);            //          same
//        System.out.println(averageOfLengths);
//
//        List<String> names4 = Arrays.asList("John", "Barry", "Chris", "John", "Chris", "Marry", "Paul");
//        // String allNamesInOneString = names4.stream().collect(Collectors.joining(", "));
//        String allNamesInOneString = String.join(", ", names4);
//        System.out.println(allNamesInOneString);


        List<String> names =
                Arrays.asList("John", "Barry", "Chris", "Marry", "Paul", "Kevin", "Anna", "Stewart", "Rina");

//        Predicate<String> isC= s -> s.charAt(0)=='C';
        Predicate<String> isC = s -> s.startsWith("C");

        names.stream().filter(isC).forEach(System.out::println);


        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Henry", 45, Arrays.asList("Mike j.", "Anna", "Tim")),
                new Employee("Michael", 29, Arrays.asList("Sue", "Tim")),
                new Employee("Garry", 50, Arrays.asList("Mich", "Sharon"))));

        List<Employee> collect = employees.stream()
                .sorted(Comparator.comparing(employee -> employee.age))
                .collect(Collectors.toList());

        collect.stream()
                .peek(System.out::println)
                .takeWhile(employee -> employee.age < 40)
                .forEach(System.out::println);

//        System.out.println(result);

        String allNames = employees.stream()
                .map(employee -> employee.name)
                .reduce("names are: ", (a, b) -> a + ", " + b);

        System.out.println(allNames);

//        Integer maxAge = employees.stream()
//                .map(employee -> employee.age).reduce(0,Integer::max);
//        System.out.println(maxAge);

        Integer maxAge = employees.stream()
                .map(employee -> employee.age).reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println(maxAge);

        List<String> names3 =
                Arrays.asList("John", "Barry");
        Integer sumOfLengths = names3.stream().collect(Collectors.summingInt(String::length)); //same
        // names.stream().mapToInt(String::length).sum(); same
        System.out.println("sum : " + sumOfLengths);


    }
}

@AllArgsConstructor
@ToString
class Employee {
    String name;
    int age;
    List<String> kids;
}
