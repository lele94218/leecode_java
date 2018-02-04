package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/22/18 6:00 PM.
 */
public class Solution259 {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < t) {
                    res += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
