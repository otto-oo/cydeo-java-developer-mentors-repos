package week_14_TicketingORMpart1;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs_3_step {
    /*
    Simba has a number of staircases in his house, and he likes to climb each staircase 1, 2, or 3 steps at a
time. Given the respective heights for each of the staircases in his house, find and print the number
of ways he can climb each staircase.
In other words, find the possible variation counts of climbing a staircase of which length is your
input.
Example
Input: 3
Output: 4

Example
Input: 4
Output: 7
     */

    public static void main(String[] args) {
        int n = 10;         // user input

        System.out.println("start");
        try {
       //     System.out.println("iteration : " + iteration(n));
            System.out.println("recursion(n) : " + recursion(n));
//            System.out.println("map_recursive(n) = " + map_recursive(n));
//            //   System.out.println("memoization_recursive(n) : " + memoization_recursive(n));
//            System.out.println("onlyWithArray(n) : " + onlyWithArray(n));
        } catch (Exception e) {
            System.err.println("WARNING : " + e.getMessage());
        }
        System.out.println("final");
    }

    // time complexity : O(3^n)
    // space complexity : O(n)
    static int recursion(int n) {
        int result = -5;
        if (n < 0) throw new IllegalArgumentException("stair numbers cannot be less than zero");
        if (n <= 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        System.out.println("before; n : " + n + " result : " + result);
        result = recursion(n - 1) + recursion(n - 2) + recursion(n - 3);
        System.out.println("\tafter; n : " + n + " result : " + result);
        return result;
    }

    // time complexity : O(n)
    // space complexity : O(1)
    static int iteration(int n) {
        if (n < 0) throw new IllegalArgumentException("stair numbers cannot be less than zero");
        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        int n1 = 1, n2 = 2, n3 = 4, result = 0;

        for (int i = 4; i <= n; i++) {
            result = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = result;
        }
        return result;
    }


    // memoization
    // time complexity : O(n)
    // space complexity : O(n)
    public static int map_recursive(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return mapUtil(n, map);
    }

    private static int mapUtil(int n, Map<Integer, Integer> map) {
        if (n < 0) throw new IllegalArgumentException("stair numbers cannot be less than zero");

        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        if (map.containsKey(n))// if solved before the use it
            return map.get(n);

        int ways = mapUtil(n - 1, map)
                + mapUtil(n - 2, map)
                + mapUtil(n - 3, map);
        map.put(n, ways);
        return ways;
    }

    // time complexity : O(n)
    // space complexity : O(n)
    public static int memoizationArray_recursive(int n) {
        int[] ways = new int[n + 1];
        return memoizationArrayUtil(n, ways);
    }

    private static int memoizationArrayUtil(int n, int[] ways) {
        if (n < 0) throw new IllegalArgumentException("stair numbers cannot be less than zero");

        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        if (ways[n] != 0) return ways[n]; // if solved before the use it

        ways[n] = memoizationArrayUtil(n - 1, ways)
                + memoizationArrayUtil(n - 2, ways)
                + memoizationArrayUtil(n - 3, ways); // first store it to use afterwards and then return the value
        return ways[n];
    }


    // Tabulation
    // time complexity : O(n)
    // space complexity : O(n)
    public static int onlyWithArray(int n) {
        if (n < 0) throw new IllegalArgumentException("stair numbers cannot be less than zero");
        int[] ways = new int[n + 1];

        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;

        for (int i = 4; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
        }
        //System.out.println("Arrays.toString(ways) = " + Arrays.toString(ways));

        return ways[n];
    }

}
