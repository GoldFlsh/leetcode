package leetcode.top

import kotlin.math.max

private val charPool: List<Char> = ('a'..'z') + ('A'..'Z')

fun main() {
    val randomString = (1..10)
        .map { kotlin.random.Random.nextInt(0, charPool.size) }
        .asSequence()
        .map(charPool::get)
        .joinToString("")

    print(randomString + " " + LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(randomString))
}

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(str: String): Int =
        when {
            str.length == 1 -> 1
            str.isEmpty() -> 0
            else -> helper(str, 0, 1, 0)
        }

    private tailrec fun helper(
        str: String,
        leftIndex: Int,
        rightIndex: Int,
        max: Int
    ): Int = when {
        rightIndex >= str.length + 1 -> max
        str.substring(leftIndex, rightIndex).isDistinct() ->
            helper(str, leftIndex, rightIndex + 1, max(rightIndex - leftIndex, max))
        else -> helper(str, leftIndex + 1, leftIndex + max + 1, max)
    }

    private fun String.isDistinct() = toSet().size == length
}