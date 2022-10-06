package week_24;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindGreaterThanRight {

    public static void main(String[] args)
    {
        int[] arr = { 10, 4, 6, 3, 5 };
        find(arr);

        System.out.println(findAllElementGreaterThanTheirRight(new int[]{10, 4, 6, 3, 5, 9, 7, 4, 8, 12}));
    }

    // Function to print all elements which are greater than all elements present to their right
    public static void find(int[] arr) {

        if (arr == null || arr.length == 0) return; // base case

        Stack<Integer> stack = new Stack<>(); // create an empty stack

        for (int value: arr) {
            // pop all the elements that are less than the current element
            while (!stack.isEmpty() && stack.peek() < value) {
                stack.pop();
            }
            stack.push(value); // push current element into the stack
        }

        while (!stack.isEmpty()) { // print all elements in the stack
            System.out.print(stack.pop() + " ");
        }
    }


    public static List<Integer> findAllElementGreaterThanTheirRight(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            while (!stack.isEmpty() && num > stack.peek()) {
                stack.pop();
            }
            stack.push(num);
        }

        return new ArrayList<>(stack);
    }
}

