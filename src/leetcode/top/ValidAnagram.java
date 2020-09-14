package leetcode.top;

import java.util.Arrays;

public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            char[] string1 = s.toCharArray();
            char[] string2 = t.toCharArray();
            Arrays.sort(string1);
            Arrays.sort(string2);
            return Arrays.equals(string1, string2);
        }
    }
}
