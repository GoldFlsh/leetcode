package leetcode.top;

import java.util.HashSet;
import java.util.Set;

class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> distinctNums = new HashSet<>(nums.length);
        for(int x: nums) {
            if(distinctNums.contains(x)) distinctNums.remove(x);
            else distinctNums.add(x);
        }

        return distinctNums.iterator().next();
    }
}