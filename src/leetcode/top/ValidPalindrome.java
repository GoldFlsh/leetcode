package leetcode.top;

import java.util.List;
import java.util.stream.Collectors;

public class ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            List<Character> chars = stripPunctuationAndConvertToCharArray(s);
            return isPalindrome(chars);
        }

        private boolean isPalindrome(List<Character> chars) {
            return isPalindromeRecursion(chars, 0, chars.size() - 1);
        }

        private boolean isPalindromeRecursion(List<Character> chars, int left, int right) {
            if (left >= right) return true;
            else if (chars.get(left) != chars.get(right)) return false;
            else return isPalindromeRecursion(chars, ++left, -- right);
        }

        private List<Character> stripPunctuationAndConvertToCharArray(String s) {
            return s.chars().mapToObj(c -> (char) c)
                    .filter(Character::isLetterOrDigit)
                    .map(Character::toLowerCase)
                    .collect(Collectors.toList());
        }
    }
}
