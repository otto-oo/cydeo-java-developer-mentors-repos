package week_30;

import java.util.Stack;

public class LongestValidParanteses {

    public static void main(String[] args) {

        System.out.println(longestValidParentheses("(())...)"));

    }

    public static int longestValidParentheses(String s){
        if(s==null){
            return 0;
        }
        Stack<Integer> stack = new Stack();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }
}


