package com.terryx.leecode.problem;

import com.terryx.main.Utils;

/**
 * @author taoranxue on 9/23/16 2:29 AM.
 */
public class Solution53 {
    public int maxSubArray0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0], prev = 0;
        for (int i = 0; i < nums.length; ++ i) {
            prev = Math.max(nums[i], prev + nums[i]);
            res = Math.max(res, prev);
        }
        return res;
    }

    private int[] a;
    private int solveIt(int left, int right) {
        if (left >= right) return a[left];
        int mid = (left + right) / 2;
        int left_max = solveIt(left, mid - 1);
        int right_max = solveIt(mid + 1, right);
        int mid_max = solveMid(mid, left, right);
            System.out.println(Utils.debug(left_max, mid_max, right_max));
        return Math.max(left_max, Math.max(right_max, mid_max));

    }
    private int solveMid(int mid, int left, int right) {

        int res1 = -999999999;
        int tmp = 0;
        for (int i = mid; i >= left; -- i) {
            tmp += a[i];
            res1 = Math.max(tmp, res1);
        }
        int res2 = -999999999;
        tmp = 0;
        for (int i = mid; i <= right; ++ i) {
            tmp += a[i];
            res2 = Math.max(tmp, res2);
        }
        return res1 + res2 - a[mid];
    }
    public int maxSubArray(int[] nums) {
        a = nums;
        return solveIt(0, nums.length - 1);
    }
}
