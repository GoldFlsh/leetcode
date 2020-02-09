package leetcode.top

fun main (args: Array<String>) {

}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        for((index1, num1) in nums.withIndex()) {
            for((index2, num2) in nums.withIndex()) {
                if (index1 != index2 && Integer.sum(num1, num2) == target) {
                    return intArrayOf(index1, index2)
                }
            }
        }
        return intArrayOf()
    }
}