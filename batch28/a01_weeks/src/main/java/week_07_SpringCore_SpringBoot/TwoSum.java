package week_07_SpringCore_SpringBoot;

import java.util.*;

public class TwoSum {
    /*
   Two Sum
Given an array of integers nums and an integer target, return the two numbers such that they add up to target.
Assume that each input would have exactly one solution, and you should not use the same element twice.
You can return the answer in any order.
No solution will return empty array.
Please, use two pointer strategy to solve this problem
(Hint : you should sort the input first).
Example:
Input: nums = [16, 3, 11, 5, 15], target = 8
Output: [3, 5]
Explanation: Because nums[1] + nums[3] => 3 + 5 = 8, we return [3, 5].

Optional additional task: Try to return original indices of the pair numbers.

     */
    public static void main(String[] args) {
        int[] nums = {16, 3, 11, 5, 15};
        //  System.out.println(Arrays.toString(findThePairNumbers(nums, 8)));
//        System.out.println(Arrays.toString(findIndicesWithTwoPointer(nums, 8)));
//        System.out.println(Arrays.toString(findIndicesWithTwoPointerAndTreeMap(nums, 8)));
//        System.out.println(Arrays.toString(findIndicesWithTwoPointerAndHashMap(nums, 8)));
//        System.out.println(Arrays.toString(nums));
    }

    //    TC: O (n2) SC: O(1)
    public static int[] findThePairNumbersWithNestedLoop(int[] distinct, int targetSum) {
        for (int i = 0; i < distinct.length; i++) {
            for (int j = i + 1; j < distinct.length; j++) {
                if (distinct[i] + distinct[j] == targetSum) {
                    return new int[]{distinct[i], distinct[j]};
                }
            }
        }
        return new int[0];
    }

    //    TC: O (n) SC: O(n)
    public static int[] findThePairNumbersWithHashSet(int[] distinct, int targetSum) {
        Set<Integer> set = new HashSet<>();
        set.add(distinct[0]);
        for (int i = 1; i < distinct.length; i++) {
            int key = targetSum - distinct[i];
            if (set.contains(key)) {
                return new int[]{key, distinct[i]};
            } else {
                set.add(distinct[i]);
            }
        }
        return new int[0];
    }

    //    TC: O (n log n) SC: O(1)
    public static int[] findThePairNumbersWithTwoPointer(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        Arrays.sort(arr);  // nlog(n)

        while (left < right) {  //n
            if (arr[left] + arr[right] == target)
                return new int[]{arr[left], arr[right]};
            else if (arr[left] + arr[right] < target) {
                left++;
            } else
                right--;
        }
        return new int[0];
    }

    //    TC: O (n2) SC: O(1)
    public static int[] findIndicesWithNestedLoop(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //    TC: O (n) SC: O(n)
    public static int[] findIndicesWithMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int neededPair = target - nums[i];
            if (!map.containsKey(neededPair)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(neededPair), i};
            }
        }
        return new int[0];
    }

    //    TC: O (n log n) SC: O(n)
    public static int[] findIndicesWithTwoPointer(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int num1, num2;
        int ind1 = -1, ind2 = -1;
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);  // n log(n)

        while (left < right) {  //n
            if (temp[left] + temp[right] == target) {
                num1 = temp[left];
                num2 = temp[right];
                for (int i = 0; i < arr.length; i++) {  //n
                    if (arr[i] == num1) {
                        ind1 = i;
                    } else if (arr[i] == num2) {
                        ind2 = i;
                    }
                }
                return new int[]{ind1, ind2};
            } else if (temp[left] + temp[right] < target) left++;
            else right--;
        }
        return new int[0];
    }

    public static int[] findIndicesWithTwoPointerAndHashMap(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {  // n
            map.put(arr[i], i);
        }
        Arrays.sort(arr);  // n log(n)

        while (left < right) {  // n
            if (arr[left] + arr[right] == target) {
                return new int[]{map.get(arr[left]), map.get(arr[right])};
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else
                right--;
        }
        return new int[0];
    }

    public static int[] findIndicesWithTwoPointerAndTreeMap(int[] arr, int target) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) { // n log (n)
            map.put(arr[i], i);
        }

        while (!map.firstKey().equals(map.lastKey())) {  // n
            if (map.firstKey() + map.lastKey() == target) {
                return new int[]{map.firstEntry().getValue(), map.lastEntry().getValue()};
            } else if (map.firstKey() + map.lastKey() < target) {
                map.remove(map.firstKey());
            } else
                map.remove(map.lastKey());
        }
        return new int[0];
    }

}
