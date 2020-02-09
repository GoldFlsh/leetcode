package leetcode.top

fun main() {
    val array1: IntArray = intArrayOf(1, 2)
    val array2: IntArray = intArrayOf(3, 4)

    val median = MedianOfTwoSortedArrays().findMedianSortedArrays(array1, array2)
    println(median)
}

class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val finalArraySize: Int = nums1.size + nums2.size
        val isOddLength: Boolean = finalArraySize % 2 != 0
        val medianIndex = determineMedianIndex(finalArraySize, isOddLength)

        return findMedian(nums1, nums2, medianIndex, isOddLength)
    }

    private fun findMedian(nums1: IntArray, nums2: IntArray, medianIndex: Int, oddLength: Boolean): Double {
        return when {
            oddLength -> findNumAtIndexWhenMergingTwoArrays(nums1, nums2, medianIndex, 0, 0).toDouble()
            //TODO Looking through the array twice for evens = yuck...
            else -> (findNumAtIndexWhenMergingTwoArrays(nums1, nums2, medianIndex, 0, 0).toDouble() +
                    findNumAtIndexWhenMergingTwoArrays(nums1, nums2, medianIndex + 1, 0, 0).toDouble()) / 2
        }
    }

    private fun findNumAtIndexWhenMergingTwoArrays(nums1: IntArray, nums2: IntArray, toIndex: Int, currentIndex: Int, sequencedNum: Int): Int {
        return when {
            currentIndex == toIndex -> sequencedNum
            nums1.isEmpty() -> findNumAtIndexWhenMergingTwoArrays(IntArray(0), nums2.copyOfRange(1, nums2.size), toIndex, currentIndex + 1, nums2[0])
            nums2.isEmpty() -> findNumAtIndexWhenMergingTwoArrays(nums1.copyOfRange(1, nums1.size), nums2, toIndex,  currentIndex + 1, nums1[0])
            nums1[0] <= nums2[0] -> findNumAtIndexWhenMergingTwoArrays(nums1.copyOfRange(1, nums1.size), nums2, toIndex,  currentIndex + 1, nums1[0])
            else -> findNumAtIndexWhenMergingTwoArrays(nums1, nums2.copyOfRange(1, nums2.size), toIndex, currentIndex + 1, nums2[0])
        }
    }

    private fun determineMedianIndex(finalArraySize: Int, oddLength: Boolean): Int {
        return when {
            oddLength -> finalArraySize / 2 + 1
            else -> finalArraySize / 2
        }
    }
}