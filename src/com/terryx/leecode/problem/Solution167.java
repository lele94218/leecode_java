package com.terryx.leecode.problem;

/**
 * @author xueta on 8/25/2016 10:10 AM.
 */
public class Solution167 {

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i] + nums[j];
            if (tmp == target) {
                return new int[]{i + 1, j + 1};
            }
            if (tmp > target) j--;
            if (tmp < target) i++;
        }
        return null;
    }
}
