package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/21/17 4:37 PM.
 */
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int max[] = new int[nums.length], min[] = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                max[i] = nums[i];
                min[i] = nums[i];
            } else {
                if (nums[i] > 0) {
                    max[i] = Math.max(nums[i], nums[i] * max[i - 1]);
                    min[i] = Math.min(nums[i], nums[i] * min[i - 1]);
                } else {
                    max[i] = Math.max(nums[i], nums[i] * min[i - 1]);
                    min[i] = Math.min(nums[i], nums[i] * max[i - 1]);
                }
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
