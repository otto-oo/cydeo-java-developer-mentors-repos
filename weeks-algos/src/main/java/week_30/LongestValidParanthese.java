package week_30;

import java.lang.*;
import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParanthese {
    public static void main(String[] args) {

        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("(()"));
    }

    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {  // inside valid substring, update result
                stack.pop();
                int validLen = stack.isEmpty() ? i + 1 : i - stack.peek();
                result = Math.max(result, validLen);
            } else {   // valid substring breaks
                stack.push(i);
            }
        }

        return result;

    }
}
