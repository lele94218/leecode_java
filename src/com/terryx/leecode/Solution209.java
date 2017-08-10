package com.terryx.leecode;

import java.util.List;

/**
 * @author taoranxue on 8/9/17 12:05 PM.
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // ----- O(n) -----
        // int res = Integer.MAX_VALUE, left = 0, sum = 0;
        // for (int i = 0; i < nums.length; ++ i) {
        //     sum += nums[i];
        //     if (sum >= s) {
        //         while (sum >= s) {
        //             res = Math.min(res, i - left + 1);
        //             sum -= nums[left++];
        //         }
        //     }
        // }
        // if (res == Integer.MAX_VALUE) res = 0;
        // return res;

        // ----- O(nlogn) -----
        int sum[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= nums.length; ++i) {
            int target = s + sum[i - 1];
            int low = 0, high = sum.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                int midVal = sum[mid];
                if (midVal == target) {
                    low = mid;
                    break;
                }
                if (midVal < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // System.out.println(low);
            if (low < sum.length)
                res = Math.min(res, low - i + 1);
        }
        if (res == Integer.MAX_VALUE) res = 0;
        return res;
    }
}
