package com.terryx.leecode;

/**
 * @author taoranxue on 8/5/17 3:40 PM.
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[idx] != nums[i]) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        return idx + 1;
    }
}
