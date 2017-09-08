package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/8/17 11:16 AM.
 */
public class Solution453 {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, min = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            min = Math.min(nums[i], min);
        }
        return sum - nums.length * min;
    }
}
