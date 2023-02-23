package week_08_CollectionReview_MVC_ThymeleafPart1;

import java.util.Arrays;

public class MoveZerosToEnd {
    /*
    Move Zeros To End in place
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0, 1, 0, 3, 12]
Output: [1, 3, 12, 0, 0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
•	1 <= nums.length <= 104
•	-2^31 <= nums[i] <= 2^31 - 1

Follow up: Could you minimize the total number of operations done?

Please, test your solution here: https://leetcode.com/problems/move-zeroes/
     */

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 0, 3, 7};
        moveZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void oneLoopOneIf(int[] nums) {
        if (nums == null) return;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
    }

    static void moveZerosToEnd(int[] arr) {
        if (arr == null) return;
        int fast = 0, slow = 0;

        while (fast < arr.length-1) {
            if (arr[slow] != 0) {
                slow++;
            }
            if (fast <= slow || arr[fast] == 0) {
                fast++;
            }
            if (arr[slow] == 0 && arr[fast] != 0) {
                arr[slow] = arr[fast];
                arr[fast] = 0;
            }
        }
    }

}
