package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 10/13/17 5:52 PM.
 */
public class Solution410 {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (m == 1) return sum;
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

    private boolean valid(int[] nums, int m, int target) {
        int cnt = 1, sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                cnt++;
            }
        }
        if (cnt > m) return false;
        return true;
    }
}
