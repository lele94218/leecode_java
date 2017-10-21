package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/20/17 2:49 PM.
 */
public class MaxSubarraySum {

    // array是否存在和为k的subarray，求最大长度

    /**
     * Hash map. O(n)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }

    // array是否存在和大于或等于k的subarray，求最小长度

    /**
     * Sliding window. O(n).
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int begin = 0, end = 0, sum = 0, res = Integer.MAX_VALUE;
        for (; end < nums.length; ++end) {
            sum += nums[end];
            while (begin <= end && sum >= s) {
                res = Math.min(res, end - begin + 1);
                sum -= nums[begin];
                begin++;
            }
        }
        return (res == Integer.MAX_VALUE ? 0 : res);
    }

    /**
     * Binary search. O(n log n).
     */
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++ i) {
            int target = s + sum[i];
            int left = 1, right = sum.length - 1, mid = 0;
            while (left <= right) {
                mid = left + (right - left >> 1);
                int midVal = sum[mid];
                if (midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left < sum.length) {
                res = Math.min(res, left - i);
            }
        }
        return (res == Integer.MAX_VALUE ? 0 : res);
    }
}
