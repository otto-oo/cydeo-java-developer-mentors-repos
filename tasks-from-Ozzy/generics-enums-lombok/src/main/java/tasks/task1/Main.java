package tasks.task1;

import java.util.Arrays;

/**
 * Write a generic method to exchange the positions of two different elements in
 * array.
 *
 * Integer[] a = {1,2,3,4};
 * swap(a,0,2);
 * System.out.println(Arrays.toString(a)); //[3,2,1,4]
 * Sample output:
 */

public class Main {

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4};

        swap(a, 0, 2);
        System.out.println(Arrays.toString(a));

        String[] strArray = {"Michael","Larry","Sue","Mary"};
        String[] swapArray = swap(strArray, 2, 3);
        System.out.println(Arrays.toString(swapArray));
    }

    private static <T> T[] swap(T[] array, int firstIndex, int secondIndex) {

        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;

        return array;
    }
}
