package com.terryx.leecode.problem;

/**
 * @author taoranxue on 8/3/17 4:49 PM.
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == 0) {
                int tl = 1;
                flag = false;
                for (int j = i - 1; j >= 0; --j) {
                    if (nums[j] > tl++) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) return false;
            }
        }
        return true;
    }
}
