package week_29_possible_algos;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram_LC_Easy {
    /*
    242. Valid Anagram
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

    https://leetcode.com/problems/valid-anagram/

     */

    public boolean withArraySort(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    public boolean withMap(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();          // Space Complexity: O(n)

        for (int i = 0; i < s.length(); i++) {                      // Time Complexity: O(n)
            if (map.containsKey(s.charAt(i))) {                     // Time Complexity: O(1)
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {                      // Time Complexity: O(n)
            if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }
        return map.size() == 0;
    }


    public boolean withArray(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {   // Time Complexity: O(n + 1) -> O(n)
            count[s.charAt(i) - 'a']++;      // increasing count of that char found in s
            count[t.charAt(i) - 'a']--;      // decreasing count of that char found in t
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)                 // every charachter count must be zero
                return false;
        }
        return true;
    }
}
