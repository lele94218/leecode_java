package com.terryx.leecode.weeklycontest.contest64;

/**
 * @author taoranxue on 1/15/18 10:34 PM.
 */
public class Solution747 {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int max = 0, index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (index == i) {
                continue;
            }
            if (nums[i] != 0 && max / nums[i] < 2) {
                return -1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution747 m = new Solution747();
        System.out.println(m.dominantIndex(new int[]{1, 2, 3, 4}));
    }
}
