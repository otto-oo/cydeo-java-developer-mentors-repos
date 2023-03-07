package z_questions;

import java.util.*;

public class longest {
    public static void main(String[] args) {
//        System.out.println(s("nndNfdfdfaabcdefabbc"));
        System.out.println(s("nndNfdfdf"));
    }

    static long tyson(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        long ans = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static long matt(String s) {
        // Type your solution here
        long max = 0;
        int left = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                left = Math.max(left,map.get(ch));
                map.put(ch,i);
            }else {
                map.put(ch,i);
                max = Math.max(max, i-left);
            }

        }
        return max+1;
    }

    static long sumeyse(String s){
        HashMap < Character, Integer > mpp = new HashMap< Character, Integer >();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);
            mpp.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
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


    static long mySolution(String s) {
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
