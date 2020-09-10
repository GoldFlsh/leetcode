package leetcode.top;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {-1};
        new Solution().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            int modRotate = k % length;
            int[] newNums = new int[nums.length];

            if (length == 1) {
                return;
            }

            for (int i = 0; i < length; i++) {
                int newIndex = findNewIndex(i, modRotate, length);
                newNums[newIndex] = nums[i];
            }

            for (int i = 0; i < length; i++) {
                nums[i] = newNums[i];
            }
        }

        public int findNewIndex(int currentIndex, int rotateCount, int length) {

            int newIndex = currentIndex + rotateCount;
            if (newIndex >= length) {
                newIndex = newIndex - length;
            }
            return newIndex;
        }
    }
}
