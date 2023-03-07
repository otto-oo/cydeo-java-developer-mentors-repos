package Intw_DSA_Qs;

import java.util.HashSet;
import java.util.Set;

public class Q1_LongestSubStr {

    //Find the Length of the longest substring without repeating characters

    static long solution2(String s){
        long max = 0;
        String sub = "";
        for (int fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            if (!sub.contains(ch+"")){
                sub = sub + ch;
            } else {
                max = Math.max(max, sub.length());
                sub = sub.substring(sub.indexOf(ch)+1)+ch;
            }
        }
        return max;
    }
    static long solution3(String s){
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
}

