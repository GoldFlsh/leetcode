package leetcode.top;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length);
            for (int i: nums) {
                if(set.contains(i)) return true;
                else set.add(i);
            }
            return false;
        }
    }
}
