package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/21/17 3:46 PM.
 */
public class LongestIncreasingSubsequence {

    /**
     * O(n^2)
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j)
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * O(n log n)
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; ++i) {
            if (stack.isEmpty() || nums[i] > stack.peek()) {
                stack.push(nums[i]);
            } else {
                int left = 0, right = stack.size() - 1, mid = 0, target = nums[i];
                while (left <= right) {
                    mid = left + (right - left >> 1);
                    int midVal = stack.get(mid);
                    if (target > midVal) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                stack.set(left, nums[i]);
            }
        }
        return stack.size();
    }

    public int longestIncreasingContinuousSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 1, res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                cnt++;
            }
            if (i == nums.length - 1 || i > 0 && nums[i] <= nums[i - 1]) {
                res = Math.max(res, cnt);
                cnt = 1;
            }
        }
        return res;
    }
}
