package week_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayOfProducts {

    public static void main(String[] args) {
        int[] givenArray = {5,1,4,2};
        System.out.println(Arrays.toString(productsOfOthers(givenArray)));
    }

    public static int[] productsOfOthers(int[] givenArray) {
        var resultArray = new ArrayList<Integer>();

        int pointer = 0;

        while (pointer < givenArray.length) {
            int finalPointer = pointer;
            int carry = Arrays.stream(givenArray).filter(n -> n != givenArray[finalPointer]).reduce(1, (a, b) -> a * b);
            resultArray.add(carry);
            pointer++;
        }
        return resultArray.stream().mapToInt(i -> i).toArray();
    }
}
