package z_questions;

import java.util.HashMap;
import java.util.Map;

public class longest {
    public static void main(String[] args) {
//        System.out.println(s("nndNfdfdfaabcdefabbc"));
        System.out.println(s("nndNfdfdf"));
    }

    public static long solution(String s) {
        // Type your solution here
        long max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
                map.clear();
                map.put(ch, i);
            } else {
                map.put(ch, i);
                max = Math.max(max, i - left);
            }

        }
        return max + 1;
    }

    static long s(String s) {
        long max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                max = Math.max(max, map.size());
                left = map.get(ch) + 1;
                map.clear();
                i = left;
            } else {
                map.put(ch, i);
            }
        }
        max = Math.max(max, map.size());
        return max;
    }


    static long solution2(String s) {
        long max = 0;
        String sub = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!sub.contains(ch + "")) {
                sub = sub + ch;
            } else {
                max = Math.max(max, sub.length());
                sub = sub.substring(sub.indexOf(ch) + 1) + ch;
            }
        }
        return max;
    }
}
