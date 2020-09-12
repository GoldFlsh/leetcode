package leetcode.top;

public class MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            int nextAvailableIndex = 0;

            for (int i = 0; i< nums.length; i++) {
                if(nums[i] != 0) { // If current Index isn't zero
                    nextAvailableIndex = handleNonZero(nums, nextAvailableIndex, i);
                }
            }
        }

        private int handleNonZero(int[] nums, int availableIndex, int currentIndex) {
            if(availableIndex != currentIndex) { // and current index isn't the same as the availableIndex
                nums[availableIndex] = nums[currentIndex]; // Shift num to next available position
                nums[currentIndex] = 0;
            }
            availableIndex++;
            return availableIndex;
        }
    }
}
