package com.terryx.leecode.weeklycontest.contest36;

import java.util.*;

/**
 * @author taoranxue on 6/10/17 10:12 PM.
 */
public class Solution611 {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int sum = nums[i] + nums[j];
                int index = Arrays.binarySearch(nums, sum);
                if (index < 0) {
                    index = -(index + 1);
                }
                index = index - 1;
                while (index > 0 && nums[index] >= sum) index--;
                if (index > j) {
                    res += index - j;
                }
            }
        }
        return res;


    }
}
