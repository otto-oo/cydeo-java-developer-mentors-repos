package Intw_DSA_Qs;

import java.util.*;

public class Q5_AliceAndNumbers {

    public static void main(String[] args) {
        int[] arr = {4, 8, 13, 30};
        System.out.println(findMinK(arr));
    }

    public static int findMinK(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int number = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                return -1;
            }

            for (int j = 2; j <= arr[i]; j++) {
                int freq = 0;
                while (number % j == 0) {
                    number = number / j;
                    freq++;
                }

                if (freq != 0) {
                    if (!map.containsKey(j)) {
                        map.put(j, freq);
                    } else {
                        if (freq > map.get(j)) {
                            map.replace(j, freq);
                        }
                    }
                }
            }
            number = arr[i + 1];
        }
        int k = 1;
        for (Map.Entry<Integer, Integer> eachEntry : map.entrySet()) {
            k *= Math.pow(eachEntry.getKey(), eachEntry.getValue());
        }
        return k;
    }
}
