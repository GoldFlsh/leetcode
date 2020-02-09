package leetcode.top;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};

    }

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueNumIndex = 0;
        int lastNum = nums[uniqueNumIndex];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != lastNum) {
                nums[++uniqueNumIndex] = nums[i];
                lastNum = nums[i];
            }
        }
        return uniqueNumIndex+1;
    }
}
}
