package leetcode.top

import kotlin.math.max

fun main(args: Array<String>) {
    val randomString: String = "baba"
    print(randomString + " " + LongestPalindromicSubstring().longestPalindrome(randomString))
}

class LongestPalindromicSubstring {
    fun longestPalindrome(str: String): Int {
        return when {
            str.length == 1 -> 1
            str.isEmpty() -> 0
            else -> longestPalindromeHelper(str)
        }
    }

    private fun longestPalindromeHelper(str: String): Int {
        return when {
            isPalindromic(str) -> str.length
            else -> max(longestPalindrome(str.substring(1)), longestPalindrome(str.substring(0,str.length-1)))
        }
    }

    private fun isPalindromic(str: String): Boolean {
        return when {
            str.length == 1 -> true
            isOddLength(str) -> str.substring(0, medianIndexOf(str)) == str.substring(medianIndexOf(str + 1)).reversed()
            else -> str.substring(0, medianIndexOf(str + 1)) == str.substring(medianIndexOf(str + 1)).reversed()
        }
    }

    private fun isOddLength(str: String): Boolean {
        return str.length % 2 == 1
    }

    /**
     * Returns the left median index for even length strings
     */
    private fun medianIndexOf(str: String): Int {
        return str.length / 2
    }
}