package week_05_optional_solid_timeComplexity;

import java.util.Arrays;
import java.util.OptionalInt;

public class Q1_FindMaxFromArray {
     /*
    Write a function that can find the maximum number from an int Array.
    input:  int[] array = {6, 8, 3, 5, 1, 9};		output: 9
     */

    public static void main(String[] args) {
        int[] array = {6, 8, 3, 5, 1, 9};
        System.out.println(maxValueWithStream(array));
    }

    public static int maxValue(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int each : array) {
            if (each > max) {
                max = each;
            }
        }
        return max;
    }

    public static int maxValueWithStream(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }

    public static int maxValueWithStream2(int[] array) {
        OptionalInt max = Arrays.stream(array).max();
        return max.orElseThrow( ()-> new IllegalArgumentException("input must contain int array with at least one element"));
    }
}
