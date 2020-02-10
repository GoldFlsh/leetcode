package leetcode.top

import kotlin.math.max

fun main(args: Array<String>) {
    val randomString: String = "babaddtattarrattatddetartrateedredividerb"
    print(randomString + " " + LongestPalindromicSubstring().longestPalindrome(randomString))
}

class LongestPalindromicSubstring {
    fun longestPalindrome(str: String): String {
        return when {
            str.length == 1 -> str
            str.isEmpty() -> str
            else -> longestPalindromeHelper(str)
        }
    }

    private fun longestPalindromeHelper(str: String): String {
        return when {
            isPalindromic(str) -> str
            else -> {
                val palindromeRight = longestPalindromeHelper(str.substring(1))
                val palindromeLeft = longestPalindromeHelper(str.substring(0, str.length-1))
                return if(palindromeLeft.length > palindromeRight.length) palindromeLeft else palindromeRight
            }
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