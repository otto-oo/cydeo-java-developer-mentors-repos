package z_questions;

import java.util.Arrays;

public class support {

    public static void main(String[] args) {

        int[] nums = {0,1};
        int n = 2;

        //1. generate an array with [0 - n]
        int[] newArray = new int[n+1]; //empty array
        for (int i = 0; i <= n; i++) {
            newArray [i] = i; //new array
        }
//        System.out.println(Arrays.toString(newArray)); //[0,1,2]
        //2. sort input in asc order
        Arrays.sort(nums);

        //3. locate the missing num in the input compared to the new array
        int result = nums.length;
        for (int i = 0; i < n; i++) {
            if (newArray[i] != nums[i]){
                System.out.println(newArray[i]);
                return;
            }
        }
        System.out.println(result);
    }
}
