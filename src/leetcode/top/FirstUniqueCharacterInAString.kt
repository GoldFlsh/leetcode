package leetcode.top

fun main() {
    val str: String = "loveleetcode"
    print(FirstUniqueCharacterInAString.Solution().firstUniqChar(str));
}

class FirstUniqueCharacterInAString {
    class Solution {
        fun firstUniqChar(s: String): Int {
            return firstUniqCharHelp(s, linkedMapOf(), hashSetOf(), 0)
        }

        private tailrec fun firstUniqCharHelp(
            s: String,
            mapOfUniqueChars: LinkedHashMap<Char, Int>,
            mapOfRepeatChars: HashSet<Char>,
            index: Int
        ): Int {
            if (s.isEmpty()) return resolveMinimumIndex(mapOfUniqueChars)

            val character = s[0]
            if (mapOfUniqueChars.containsKey(character) || mapOfRepeatChars.contains(character)) {
                mapOfUniqueChars.remove(character)
                mapOfRepeatChars.add(character)
            }
            else mapOfUniqueChars[character] = index
            return firstUniqCharHelp(s.substring(1), mapOfUniqueChars, mapOfRepeatChars, index + 1)
        }

        private fun resolveMinimumIndex(mapOfUniqueChars: LinkedHashMap<Char, Int>): Int {
            return mapOfUniqueChars.values.min() ?: -1 // get minimum or default to -1
        }
    }
}