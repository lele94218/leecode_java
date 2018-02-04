package com.terryx.leecode.problem;

/**
 * @author taoranxue on 8/5/17 3:54 PM.
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int idx = 0;
        boolean flag = false;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[idx] != nums[i]) {
                ++idx;
                nums[idx] = nums[i];
                flag = false;
            } else if (!flag) {
                ++idx;
                nums[idx] = nums[i];
                flag = true;
            }


        }
        // System.out.println(idx);
        return idx + 1;
    }
}
