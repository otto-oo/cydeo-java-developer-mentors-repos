package week_09_Validation_ThymeleafPart2_TicketingMVCPart1;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /*
        202. Happy Number
        Write a function that returns true if a number is a happy number, and false if it is an unhappy number.

        A happy number is a number defined by the following process:
            Starting with any positive integer, replace the number by the sum of the squares of its digits.
            Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
            Those numbers for which this process ends in 1 are happy.

        EXAMPLE 1:
        Input: n = 19
        Output: True
        Explanation:
            19 is Happy Number,
            1^2 + 9^2 = 82
            8^2 + 2^2 = 68
            6^2 + 8^2 = 100
            1^2 + 0^2 + 0^2 = 1
            As we reached to 1, 19 is a Happy Number.

        EXAMPLE 2:
        Input: n = 20
        Output: False

        leetcode link : https://leetcode.com/problems/happy-number/
     */

    public static void main(String[] args) {
        int[] input = {4,       19,     20,     2,      365,    256};
        // expected : false,   true,   false,   false,  true,   false
        for (int each : input) {
            System.out.println(solutionWithNestedLoop(each));
            System.out.println(solutionWithSet(each));
            System.out.println(twoPointer(each));
            System.out.println(solutionWithRecursion(each));
            System.out.println("--------------------");
        }

    }

    public static boolean solutionWithNestedLoop(int n) {
        // it becomes infinite loop if n = 4
        while (n != 1 && n != 4) {
            int eachDigit, sum = 0;

            while (n > 0) {
                eachDigit = n % 10;
                sum = sum + (eachDigit * eachDigit);
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }

    /*
    A number will not be a Happy Number when it makes a loop in its sequence that is it touches a number in sequence
    which already been touched. So to check whether a number is happy or not, we can keep a set, if the same number
    occurs again we flag result as not happy.
     */
    static boolean solutionWithSet(int n) {
        Set<Integer> seenSet = new HashSet<>();
        while (seenSet.add(n)) {
            if (n == 1)
                return true;
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = sum;
        }
        return false;
    }

    // We can solve this problem without using extra space and that technique can be used in some other similar problems also.
    // If we treat every number as a node and replacement by square sum digit, then this problem is same as
    // finding a loop in a linklist : we will keep two numbers slow and fast both initialize from a given number,
    // slow is replaced one step at a time and fast is replaced two steps at a time. If they meet at 1,
    // then the given number is Happy Number otherwise not.

    static boolean twoPointer(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    static int findSquareSum(int n) {
        int squareSum = 0;
        while (n != 0) {
            int eachDigit = n % 10;
            squareSum += eachDigit * eachDigit;
            n /= 10;
        }
        return squareSum;
    }

    static boolean solutionWithRecursion(int n) {
        // In single digit number, only 1 and 7 are happy numbers
        if (n < 10 && n != 1 && n != 7)
            return false;
        if (n == 1 || n == 7) return true;
        int sum = findSquareSum(n);
        return solutionWithRecursion(sum);
    }
}
