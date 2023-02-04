package week_04_sorting_methodReference_stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static week_04_sorting_methodReference_stream.DataGenerator.*;

class StreamPractice {



    private static List<Employee> employees;
    private static List<String> names;
    private static Stream<String> streamOfValue;

    public static void main(String[] args) {

        createStreams();
        // INTERMEDIATE OPERATIONS:
//        filter();
//        limit_skip();
//        sort();
//        map();
//        flatMap();

        // TERMINAL OPERATIONS:
//        matches();
//        findAny_findFirst();
//        reduce();
//        forEach();

        //collect() & Collectors Utility Class
//        collectors_basics();
        collectors_toMap_partitioningBy_groupingBy();
//        mapToInt_collectors_summingInt();
//        count_collectors_counting();
//        collectors_joining_String_join();
    }

    static void createStreams() {
        employees = Arrays.asList(
                new Employee("Henry", 45,
                        Arrays.asList("Mike j.", "Anna", "Tim")),
                new Employee("Mike", 29,
                        Arrays.asList("Sue", "Tim")),
                new Employee("Mike", 15,
                        Arrays.asList("John", "Tim")),
                new Employee("Garry", 50,
                        Arrays.asList("Mich", "Sharon")));

        Stream<Employee> streamOfCollection = employees.stream();

        names = Arrays.asList("John", "Barry", "Chris", "Marry", "Paul", "Kevin", "Anna", "Stewart", "Rina");

        Map<String, Integer> allUserMap = Map.of(
                "Marry", 55,
                "Gerard", 47,
                "Terry", 23);

        Stream<Map.Entry<String, Integer>> streamOfMap = allUserMap.entrySet().stream();
        List<String> allInStringList = streamOfMap
                .filter(user -> user.getValue() > 20)
                .map(user -> user.getKey() + ": " + user.getValue() + " years old")
                .collect(Collectors.toList());
//        System.out.println(allInStringList);

        String[] namesOfArray = {"John", "Barry", "Chris"};

        Stream<String> streamOfArray = Arrays.stream(namesOfArray); //OR
        //This stream will just have John and Barry as elements :
        Stream<String> streamOfArrayWithSpecifiedIndex = Arrays.stream(namesOfArray, 0, 2);

        streamOfValue = Stream.of("John", "Barry", "Chris", "Marry", "Paul", "Kevin", "Anna", "Stewart", "Rina");
    }

    static void filter() {
        System.out.print(ANSI_BLUE + "filter -> length()>5 : " + ANSI_RESET);
        streamOfValue.filter(name -> name.length() > 5).forEach(System.out::println);

        Predicate<String> isC = s -> s.charAt(0) == 'C';
//        Predicate<String> isC = s -> s.startsWith("C");   // same

        List<String> namesC = names.stream()
                .filter(isC)
                .collect(Collectors.toList());
        System.out.println("namesC : " + namesC);
    }

    static void limit_skip() {
        System.out.print(ANSI_BLUE + "limit(2) : " + ANSI_RESET);
        names.stream().limit(2).forEach(n -> System.out.print(n + ", ")); // John, Barry,

        System.out.print("\n" + ANSI_BLUE + "skip(4) : " + ANSI_RESET);
        names.stream().skip(4).forEach(n -> System.out.print(n + ", ")); // Paul, Kevin, Anna, Stewart, Rina,
    }

    static void sort() {
        System.out.print("\n" + ANSI_BLUE + "sort : " + ANSI_RESET);
        System.out.print("\n" + ANSI_GREEN + "\tnatural sort : " + ANSI_RESET);

        names.stream().sorted().forEach(n -> System.out.print(n + ", "));

        // works with the help of inheritance of Comparable in Employee class:
        employees.stream().sorted().forEach(System.out::println);

        System.out.println("\n" + ANSI_GREEN + "\tsort with comparator : " + ANSI_RESET);
        employees.stream()
                .sorted(Comparator.comparing(employee -> employee.age))
                .forEach(System.out::println);
    }

    static void map() {
        System.out.println("\n" + ANSI_BLUE + "map() : " + ANSI_RESET);

        names.stream()
//                .map(name -> name.length())       // same
                .map(String::length)        // same
                .forEach(n -> System.out.print(n + ", "));

        System.out.print("\n" + ANSI_GREEN + "\t map name.startsWith(\"K\") : " + ANSI_RESET);
        names.stream()
                .map(name -> name.startsWith("K"))
                .forEach(System.out::println);


        // ----------------------------------------
        System.out.print("\n" + ANSI_GREEN + "\tcreating map of collections framework : " + ANSI_RESET);
        names.stream()
                .distinct()
                .map(name -> {
                    Map<String, Integer> namesMap = new HashMap<>();
                    namesMap.put(name, name.length());
                    return namesMap;
                })
                .forEach(System.out::println);
    }

    static void flatMap() {
        System.out.println("\n" + ANSI_BLUE + "flatMap() : " + ANSI_RESET);
        System.out.print("\n" + ANSI_GREEN + "\t children without flatMap() : " + ANSI_RESET);
        employees.stream()
                .map(employee -> employee.children)
                .forEach(System.out::println);

        System.out.print("\n" + ANSI_GREEN + "\t children with flatMap() : " + ANSI_RESET);
        employees.stream()
                .flatMap(employee -> employee.children.stream())
                .forEach(c -> System.out.print(c + ", "));

    }

    static void matches() {
        System.out.println("\n" + ANSI_BLUE + "matches : " + ANSI_RESET);

        System.out.print("\n" + ANSI_GREEN + "\t allMatch() : " + ANSI_RESET);
        boolean isAllMatch = employees.stream().allMatch(employee -> employee.age > 20);
        System.out.print(isAllMatch);

        System.out.print("\n" + ANSI_GREEN + "\t anyMatch() : " + ANSI_RESET);
        boolean isAnyMatch = employees.stream().anyMatch(employee -> employee.age > 48);
        System.out.print(isAnyMatch);

        System.out.print("\n" + ANSI_GREEN + "\t noneMatch() : " + ANSI_RESET);
        boolean isNoneMatch = employees.stream().noneMatch(employee -> employee.age > 55);
        System.out.print(isNoneMatch);
    }

    static void findAny_findFirst() {
        System.out.println("\n" + ANSI_BLUE + "find : " + ANSI_RESET);

        System.out.print("\n" + ANSI_GREEN + "\t findFirst() : " + ANSI_RESET);
        Optional<Employee> findFirst = employees.stream().findFirst();
        System.out.println(findFirst);


        System.out.print("\n" + ANSI_GREEN + "\t findAny() : " + ANSI_RESET);
        Optional<Employee> findAny = employees.stream().findAny();
        System.out.println(findAny);
    }

    static void reduce() {
        System.out.println("\n" + ANSI_BLUE + "reduce : " + ANSI_RESET);

        System.out.print(ANSI_GREEN + "\t reduce without identity : " + ANSI_RESET);
        Optional<Integer> reducedAge = employees.stream()
                .map(employee -> employee.age)
//                .reduce((a, b) -> a + b)          // same
                .reduce(Integer::sum);    // same
        System.out.println(reducedAge);

        System.out.print(ANSI_GREEN + "\t reduce with identity : " + ANSI_RESET);
        Integer reducedAge2 = employees.stream()
                .map(employee -> employee.age)
//                .reduce(0,(a, b) -> a + b);                    // same
                .reduce(0, Integer::sum);      // same
        System.out.println(reducedAge2);

        String allNames = employees.stream()
                .map(employee -> employee.name)
                .reduce("names are: ", (a, b) -> a + ", " + b);
        System.out.println(allNames);

        Integer maxAge = employees.stream()
                .map(employee -> employee.age).reduce(0, Integer::max);
        System.out.println(maxAge);

        Employee m = employees.stream()
                .max(Comparator.comparing(employee -> employee.age))
                .orElse(null);
        System.out.println("m = " + m);
    }

    static void forEach() {
        System.out.println("\n" + ANSI_BLUE + "forEach : " + ANSI_RESET);
        employees.stream()
                .map(employee -> employee.children.get(0))
                .forEach(System.out::println);
    }

    static void collectors_basics() {
        System.out.println("\n" + ANSI_BLUE + "collectors_basics : " + ANSI_RESET);

        System.out.println("\n" + ANSI_BLUE + "toList()\n : " + ANSI_RESET);
        List<String> namesInList = names.stream()
                .filter(name -> name.startsWith("C"))
                .collect(Collectors.toList());
        System.out.println(namesInList);

        // -----------------------------------------------------------
        System.out.print("\n" + ANSI_GREEN + "\t toSet() :\n" + ANSI_RESET);
        Set<String> namesInSet = names.stream()
                .filter(name -> name.startsWith("C"))
                .collect(Collectors.toSet());
        System.out.println(namesInSet);

        // -----------------------------------------------------------
        System.out.print("\n" + ANSI_GREEN + "\t toCollection() – ArrayList :\n" + ANSI_RESET);
        ArrayList<String> namesInArrayList = names.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(namesInArrayList);

        // -----------------------------------------------------------
        System.out.println("\n" + ANSI_BLUE + "toCollection() – HashSet:\n " + ANSI_RESET);
        List<String> names = Arrays.asList("John", "Barry", "Chris", "John", "Chris", "Marry", "Paul");
        HashSet<String> namesInHashSet = names.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(namesInHashSet);
    }

    static void collectors_toMap_partitioningBy_groupingBy() {
        System.out.println("\n" + ANSI_BLUE + "Collectors.toMap(Function keyMapper, Function valueMapper) : " + ANSI_RESET);

        System.out.println("\t" + ANSI_GREEN + "toMap : " + ANSI_RESET);
        Map<String, Integer> namesInMap = names.stream()
                .distinct()     // We put distinct() method to have unique keys!!!
                //.collect(Collectors.toMap(n -> n, String::length));                                           // same
                .collect(Collectors.toMap(Function.identity(), String::length));    // same
        System.out.println(namesInMap);

        Map<Integer, List<String>> employeeAgeAndChildren = employees.stream()
                .collect(Collectors.toMap(employee -> employee.age, e -> e.children));
        System.out.println("employeeAgeAndChildren = " + employeeAgeAndChildren);

        Map<String, Integer> employeeNameAndNumberOfChildren = employees.stream()
                .distinct()     // works with the help of overridden equals & hashcode methods
                .collect(Collectors.toMap(employee -> employee.name, e -> e.children.size()));
        System.out.println("employeeNameAndNumberOfChildren = " + employeeNameAndNumberOfChildren);

        // ----------------------------------------
        System.out.println("\t" + ANSI_GREEN + "partitioningBy(Predicate predicate) : " + ANSI_RESET);
        Map<Boolean, List<String>> partitionNames = names.stream()
                .collect(Collectors.partitioningBy(name -> name.length() > 4));
        System.out.println(partitionNames);

        // ----------------------------------------
        System.out.println("\t" + ANSI_GREEN + "groupingBy(Function classifier) : " + ANSI_RESET);
        Map<String, List<Employee>> groupInNames = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.name));
        System.out.println(groupInNames);


    }

    static void mapToInt_collectors_summingInt() {
        System.out.println("\n" + ANSI_BLUE + "mapToInt() vs Collectors.summingInt(ToIntFunction mapper) : " + ANSI_RESET);

        System.out.println("\t" + ANSI_GREEN + "Collectors.summingInt(ToIntFunction mapper) : " + ANSI_RESET);

        List<String> names2 = Arrays.asList("John", "Barry");
        Integer sumOfLengths = names2.stream()
//                .collect(Collectors.summingInt(n -> n.length()));                 // same
                .collect(Collectors.summingInt(String::length));     // same
        System.out.println(sumOfLengths);

        System.out.println("\t" + ANSI_GREEN + "mapToInt() : " + ANSI_RESET);
        Integer sumOfLengths2 = names2.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println(sumOfLengths2);

        System.out.println("\t" + ANSI_GREEN + "Collectors.averagingInt(ToIntFunction mapper) : " + ANSI_RESET);
        double averageOfLengths = names2.stream()
                //.collect(Collectors.averagingInt(name -> name.length()));                     // same
                //.collect(Collectors.averagingInt(String::length));                            // same
                .mapToInt(String::length)
                .average().orElse(Double.MIN_NORMAL);                                      // same
        System.out.println(averageOfLengths);
    }

    static void count_collectors_counting() {
        System.out.println("\n" + ANSI_BLUE + "Stream.count() vs Collectors.counting() : " + ANSI_RESET);

        System.out.println("\t" + ANSI_GREEN + "Stream.count() : " + ANSI_RESET);
        long namesEndsWithY = employees.stream()
                .filter(employee -> employee.name.endsWith("y"))
                .count();                                   // better to use
        System.out.println(namesEndsWithY);

        // ----------------------------------------
        System.out.println("\t" + ANSI_GREEN + "mapToInt() : " + ANSI_RESET);
        Long numberOfElements2 = employees.stream()
                .filter(employee -> employee.name.endsWith("y"))
                .collect(Collectors.counting());
        System.out.println(numberOfElements2);
    }

    static void collectors_joining_String_join() {
        System.out.println("\n" + ANSI_BLUE + "Collectors.joining(ToIntFunction mapper) : " + ANSI_RESET);

        // ----------------------------------------
        System.out.println("\n" + ANSI_BLUE + "mapToInt() : " + ANSI_RESET);

        String allNamesInOneString = names.stream()
                .collect(Collectors.joining(", "));                     // same
        System.out.println(allNamesInOneString);

        String allNamesInOneString2 = String.join(", ", names);         // same
        System.out.println(allNamesInOneString2);

    }


    static void takeWhile() {
        List<Employee> collect = employees.stream()
                .sorted(Comparator.comparing(employee -> employee.age))
                .collect(Collectors.toList());

        collect.stream()
                .peek(System.out::println)
                .takeWhile(employee -> employee.age < 40)
                .forEach(System.out::println);
    }
}


