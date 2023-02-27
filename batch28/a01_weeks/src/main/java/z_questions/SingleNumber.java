package z_questions;

import java.util.*;

public class SingleNumber {
    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1

Example 2:

Input: nums = [4,1,2,1,2]
Output: 4

Example 3:

Input: nums = [1]
Output: 1

Constraints:
    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.
     */

    public static void main(String[] args) {
        System.out.println(withXOR(new int[]{4, 1, 2, 1, 2}));
    }

    // TC O(n^2) SC O(1)
    static int bruteForce(int[] nums) {

        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (num == i) {
                    count++;
                }
            }
            if (count == 1) return num;
        }

        return Integer.MIN_VALUE;
    }

    // Sorting + Linear traversal
    // TC O(n log (n) ) SC O(1)
    //TC = O(n log n)[because of sorting] + O(n/2)[traversing every other element of array] = O(n log n)
    static int withSorting(int[] nums) {
        Arrays.sort(nums);  // 1,1,2,2,3, 4,4   n log n
        for (int i = 0; i < nums.length - 1; i += 2) {    //i+=2 as we want to check every other element
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];   //if we didn't find answer in the loop, return the last element.
    }

    // TC O(n^2)  SC O(n)
    static int withList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            if (list.contains(num)) {
                list.remove(num);
            } else {
                list.add(num);
            }
        }
        return list.get(0);
    }

    // TC O(n)  SC O(n)
    static int withSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) set.remove(num);
//            if (set.contains(num))
//                set.remove(num);
//            else
//                set.add(num);
        }
        return set.iterator().next(); // Single Number;
        // return (int) set.toArray()[0];
    }

    // TC O(n)  SC O(n)
    public int withMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
//            if (map.containsKey(num))
//                map.replace(num, map.get(num), map.get(num) + 1);
//            else
//                map.put(num, 1);
        }

        for (int num : nums) {
            if (map.get(num) == 1)
                return num;
        }
        return 0;
    }

    /*
    Bit Manipulation (XOR)
    Concept :
XOR of zero and some bit returns that bit i.e. x^0 = x...
XOR of two same bits returns 0 i.e. x^x = 0...
And, x^y^x = (x^x)^y = 0^y = y...
XOR all bits together to find the unique number.

-If we use XOR operator between two same values, it will return zero.
-If one of the value is zero, and the other is non-zero, it returns the non-zero value.

XOR
X^X = 0
0^X = X

Let's see some rules:
0^A=A
A^A=0
A^B^A=B
(A^A^B) = (B^A^A) = (A^B^A) = B This shows that position doesn't matter.
Similarly , if we see , A^A^A.. with (even times)=0 and A^A^A.. with (odd times)=A

We apply the above observations :

Because, the elements with frequency=2 will result in 0. And then the only element with frequency=1 will generate the answer.

Our array is : {4,1,2,1,2}
4^1
4^1^2
4^1^2^1 ->[1^1=0]
4^2
4^2^2 -> [2^2=0]
4
So, the element which we got as left should be our answer, so the answer is '4'
     */

    //Time complexity: O(n), Space complexity: O(1)
    static int withXOR(int[] nums) {
        int value = 0;
        for (int num : nums) {
            value = value ^ num;
        }
        return value;
    }

    static int withXOR2(int[] nums) {
        int result = 0;
        for (int i : nums) {
            // Concept of XOR...
            result ^= i;
        }
        return result;
    }

}
