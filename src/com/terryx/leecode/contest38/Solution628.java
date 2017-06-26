package com.terryx.leecode.contest38;

import java.util.Arrays;

/**
 * @author taoranxue on 6/24/17 9:31 PM.
 */
public class Solution628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        } else {
            return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        }
    }
}
