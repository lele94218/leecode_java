package com.terryx.leecode.weeklycontest.contest58;

import java.util.*;

/**
 * @author taoranxue on 1/30/18 10:19 PM.
 */
public class Solution724 {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; ++i) {
            if (sum[i] == sum[nums.length] - sum[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution724 m = new Solution724();
        System.out.println(m.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(m.pivotIndex(new int[]{1, 2, 3}));
    }
}
