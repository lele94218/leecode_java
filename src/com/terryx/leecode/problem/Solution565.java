package com.terryx.leecode.problem;

/**
 * @author taoranxue on 8/10/17 9:55 PM.
 */
public class Solution565 {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= 0) {
                int cur = nums[i], cnt = 0;
                while (nums[cur] >= 0) {
                    int tmp = nums[cur];
                    if (nums[cur] != 0)
                        nums[cur] = -nums[cur];
                    else
                        nums[cur] = Integer.MIN_VALUE;
                    cur = tmp;
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
