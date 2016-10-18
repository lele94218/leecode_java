package com.terryx.leecode;

/**
 * @author taoranxue on 10/18/16 12:43 AM.
 */
public class Solution198 {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        int f[] = new int[nums.length + 1];
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) f[i] = nums[i];
            else if (i == 1) f[i] = Math.max(nums[i], f[i - 1]);
            else f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
