package leetcode.top

fun main() {

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

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val context: HashMap<Int, Int> = HashMap()
        for ((index, num) in nums.withIndex()) {
            val compliment: Int = target - num
            if(context.containsKey(compliment)) return intArrayOf(context[compliment]!!, index)

            context[num] = index
        }
        return intArrayOf()
    }
}