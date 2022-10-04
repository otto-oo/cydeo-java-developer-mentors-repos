package week_25;

import java.util.List;

public class ContainerWithMostWater_LC_medium {
    /*
11. Container With Most Water

    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1

leetcode link : https://leetcode.com/problems/container-with-most-water/
     */
    public static void main(String[] args) {
        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] heights2 = {1, 8, 6, 2, 5, 4, 8, 3, 1};
        int[] heights3 = {1, 1};
        List<int[]> list = List.of(heights1, heights2, heights3);
        list.forEach(
             p -> {
                 System.out.print(nestedLoop(p) + "  ");
                 System.out.println(twoPointer(p));
             }
        );
    }

    public static int nestedLoop(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = Math.min(height[i], height[j]);
                int area = temp * (j - i);
                result = Math.max(area, result);
            }
        }
        return result;
    }


    public static int twoPointer(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;
        while (left < right) {
            int temp = Math.min(height[left], height[right]);
            int area = temp * (right - left);
            result = Math.max(area, result);
            if (height[left] <= height[right]) {
                left++;
            } else
                right--;
        }
        return result;
    }
}
