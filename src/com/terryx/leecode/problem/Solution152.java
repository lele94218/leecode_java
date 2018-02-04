package com.terryx.leecode.problem;

/**
 * @author taoranxue on 10/20/16 7:35 PM.
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        if (nums == null) return 1;
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int res = max;
        for (int i = 1; i < n; ++ i) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);
            res = Math.max(res, max);
        }
        return res;
    }
}
