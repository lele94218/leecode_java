package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/19/17 5:03 PM.
 */
public class SplitArrayLargestSum {

    /**
     * Follow up 1. 分成m个sub-array O(nlogn)
     */
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        int left = max, right = sum, mid = 0;
        while (left <= right) {
            mid = left + (right - left >> 1);
            if (valid(nums, m, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean valid(int[] nums, int m, int val) {
        int sum = 0, cnt = 1;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum > val) {
                cnt++;
                sum = nums[i];
            }
        }
        return cnt <= m;
    }
}
