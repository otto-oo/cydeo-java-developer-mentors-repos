package week_26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        int[] input = {2, 2, 1};
        System.out.println(findSingleOn2(input));
        System.out.println(findSingle1(input));
        System.out.println(findSingle2(input));
        System.out.println(findSingle3(input));
        System.out.println(findSingle4(input));

    }

    public static int findSingleOn2(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (Integer num : nums) {
            if (!result.remove(num)) {
                result.add(num);
            }
        }
        return result.get(0);
    }

    public static int findSingle1(int[] nums) {
        Set<Integer> setOfNums = new HashSet<>();

        for (Integer num : nums) {
            if (setOfNums.contains(num)) {
                setOfNums.remove(num);
            } else {
                setOfNums.add(num);
            }
        }
        return (int) setOfNums.toArray()[0];
    }

    public static int findSingle2(int[] nums) {
        Set<Integer> setOfNums = new HashSet<>();

        for (Integer num : nums) {
            if (!setOfNums.remove(num)) {
                setOfNums.add(num);
            }
        }
        return setOfNums.iterator().next();
    }

    public static int findSingle3(int[] nums) {
        Set<Integer> setOfNums = new HashSet<>();

        for (Integer num : nums) {
            if (!setOfNums.add(num)) {
                setOfNums.remove(num);
            }
        }
        return setOfNums.iterator().next();
    }

    public static int findSingle4(int[] nums) {
        int result = 0;
        for(int i : nums){
            result ^= i;
        }
        return result;
    }
}
