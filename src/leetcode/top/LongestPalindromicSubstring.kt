package leetcode.top

import kotlin.math.max

fun main(args: Array<String>) {
    val randomString: String = "baba";
    print(randomString + " " + LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(randomString))
}

class LongestPalindromicSubstring {
    fun lengthOfLongestSubstring(str: String): Int {
        return when {
            str.length == 1 -> 1
            str.isEmpty() -> 0
            else -> helper(str, 0, 1, 0)
        }
    }

    private tailrec fun helper(str: String, leftIndex: Int, rightIndex: Int, max: Int): Int {
        return when {
            rightIndex >= str.length + 1 -> max
            rightIndex >= str.length && isPalindromic(str.substring(leftIndex)) ->
                helper(str, leftIndex, rightIndex + 1, max(rightIndex - leftIndex, max))
            isPalindromic(str.substring(leftIndex, rightIndex)) ->
                helper(str, leftIndex, rightIndex + 1, max(rightIndex - leftIndex, max))
            else -> helper(str, leftIndex + 1, leftIndex + 2, max)
        }
    }

    private fun isPalindromic(str: String): Boolean {
        return when {
            isOddLength(str) -> str.substring(0, medianIndexOf(str)) == str.substring(medianIndexOf(str + 1)).reversed()
            else -> str.substring(0, medianIndexOf(str + 1)) == str.substring(medianIndexOf(str + 1)).reversed()
        }
    }

    private fun isOddLength(str: String): Boolean {
        return str.length % 2 == 0
    }

    /**
     * Returns the left median index for even length strings
     */
    private fun medianIndexOf(str: String): Int {
        return str.length / 2
    }
}