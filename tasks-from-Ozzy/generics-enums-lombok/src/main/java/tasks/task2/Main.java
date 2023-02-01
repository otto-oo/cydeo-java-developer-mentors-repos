package tasks.task2;

import java.util.Arrays;
import java.util.List;


/**
 *Write a generic method to count the number of elements in a collection that
 * have a specific property (for example, odd integers, prime numbers).
 * Use following interface in your solution as well:
 *
 * Sample output:
 * public interface UnaryPredicate<T> {
 * public boolean test(T obj);
 * }
 *
 * List<Integer> ci = Arrays.asList(1, 2, 3, 4);
 * int count = countIf(ci, new OddPredicate());
 * System.out.println("Number of odd integers = " + count);
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        int count = countIf(list, new OddPredicate());

        System.out.println("Number of odd integers = " + count);

        List<String> names = Arrays.asList("John","Mary","Sue");

        System.out.println(countIf(names,new MoreThan3Predicate()));


    }

    private static <T> int countIf(List<T> list, UnaryPredicate<T> unaryPredicate) {

        int count = 0;

        for (T element : list) {
            count = unaryPredicate.test(element) ? count + 1 : count;
        }
        return count;
    }


}
