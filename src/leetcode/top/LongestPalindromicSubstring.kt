package leetcode.top

fun main() {
    val randomString1 = "babaddtattarrattatddetartrateedredividerb"
    val randomString2 = "cbbd"
    val randomString3 = "aa"
    println(randomString1 + " " + LongestPalindromicSubstring().longestPalindrome(randomString1))
    println(randomString2 + " " + LongestPalindromicSubstring().longestPalindrome(randomString2))
    println(randomString3 + " " + LongestPalindromicSubstring().longestPalindrome(randomString3))
}

private const val TRUE = 0
private const val FALSE = 1
private const val UNDEFINED = -1


class LongestPalindromicSubstring {

    fun longestPalindrome(
        str: String
    ): String = when {
        str.isEmpty() -> str
        str.length == 1 -> str
        else -> {
            val memoTable = Array(str.length) { Array(str.length) { UNDEFINED } }
            fillMemoTableDiagonal(memoTable)
            longestPalindromeHelper(str, 0, 1, memoTable, str[0].toString())
        }
    }

    private tailrec fun longestPalindromeHelper(
        str: String,
        leftIndex: Int,
        length: Int,
        memoTable: Array<Array<Int>>,
        longestPalindrome: String
    ): String =
        when {
            length > str.length -> longestPalindrome
            rightIndex(leftIndex, length) == str.length ->
                longestPalindromeHelper(
                    str,
                    0,
                    length + 1,
                    memoTable,
                    longestPalindrome
                )
            else -> longestPalindromeHelper(
                str,
                leftIndex + 1,
                length,
                memoTable,
                longestPalindromeOf(str, leftIndex, length, memoTable, longestPalindrome)
            )
        }

    private fun longestPalindromeOf(
        str: String,
        leftIndex: Int,
        length: Int,
        memoTable: Array<Array<Int>>,
        longestPalindrome: String
    ): String {
        val rightIndex = rightIndex(leftIndex, length)
        return when {
            isPalindrome(str, leftIndex, length, memoTable) -> {
                memoTable[leftIndex][rightIndex] = TRUE
                when {
                    length > longestPalindrome.length -> str.substring(leftIndex, rightIndex + 1)
                    else -> longestPalindrome
                }
            }
            else -> {
                memoTable[leftIndex][rightIndex] = FALSE
                longestPalindrome
            }
        }
    }

    private fun isPalindrome(
        str: String,
        leftIndex: Int,
        length: Int,
        memoTable: Array<Array<Int>>
    ): Boolean =
        when (length) {
            1 -> true
            2 -> str[leftIndex] == str[rightIndex(leftIndex, length)]
            else -> str[leftIndex] == str[rightIndex(leftIndex, length)] &&
                    memoTable[leftIndex + 1][rightIndex(leftIndex, length) - 1] == TRUE
        }


    private fun rightIndex(leftIndex: Int, length: Int) = leftIndex + length-1

    private fun fillMemoTableDiagonal(memoTable: Array<Array<Int>>) {
        for (i in 1 until memoTable.size) {
            memoTable[i][i] = TRUE
        }
    }
}

