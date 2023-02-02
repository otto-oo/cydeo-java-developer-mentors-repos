package week_04_sorting_methodReference_stream;

import java.util.Arrays;
import java.util.List;

class DataGenerator {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static Address address1 = new Address("7925 Jones Branch Dr, #3300", "Tysons", "Virginia", "VA", "United States", "22102-1234");
    public static Address address2 = new Address("Future Street", "Times Square", "Atlanta", "Georgia", "United States", "30310-4321");
    public static Address address3 = new Address("North Street", "Circle Square", "San Francisco", "California", "United States", "94117-8546");
    public static Address address4 = new Address("East Street", "Cube Square", "Los Angeles", "California", "United States", "90004-8426");

    public static List<Employee> employees = Arrays.asList(
            new Employee("Henry", 45,
                    Arrays.asList("Mike j.", "Anna", "Tim"), address1),
            new Employee("Michael", 29,
                    Arrays.asList("Sue", "Tim"), address2),
            new Employee("Michael", 15,
                    Arrays.asList("John", "Tim"), address3),
            new Employee("Garry", 50,
                    Arrays.asList("Mich", "Sharon"), address4)
    );

    public static List<String> names= Arrays.asList("John", "Barry", "Chris", "Marry", "Paul", "Kevin", "Anna", "Stewart", "Rina");

}
