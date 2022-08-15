package tasks.task4;

import java.util.Arrays;
import java.util.List;

/**
 * Will the following method compile? If not, why?
 * public static void print(List<? extends Number> list) {
 * for (Number n : list)
 * System.out.print(n + " ");
 * System.out.println();
 * }
 */
public class Main {

    public static void main(String[] args) {

        print(Arrays.asList(1,100,1000,100.50));
    }

    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }

//    public static void print(List<Number> list) {
//        for (Number n : list)
//            System.out.print(n + " ");
//        System.out.println();
//    }
}
