package leetcode.top;

public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            int halfway = s.length/2;
            for(int i = 0; i < halfway; i++) {
                char tmp = s[i];
                int compliment = s.length - 1 - i;
                s[i] = s[s.length - 1 - i];
                s[compliment] = tmp;
            }
        }
    }

    public void reverseStringRecursion(char[] s) {
        recurseHelper(s, 0, s.length - 1);
    }

    private void recurseHelper(char[] str, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            char tmp = str[leftIndex];
            str[leftIndex] = str[rightIndex];
            str[rightIndex] = tmp;
            recurseHelper(str, ++leftIndex, --rightIndex);
        }
    }
}
