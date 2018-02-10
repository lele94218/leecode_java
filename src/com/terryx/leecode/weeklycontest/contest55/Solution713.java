package com.terryx.leecode.weeklycontest.contest55;

import java.util.*;

/**
 * @author taoranxue on 2/8/18 9:04 PM.
 */
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int begin = 0, end = 0, res = 0, sum = 1;
        for (; end < nums.length; ++end) {
            sum *= nums[end];
            while (begin <= end && sum >= k) {
                sum /= nums[begin++];
            }
            res += (end - begin + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution713 m = new Solution713();
        System.out.println(m.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
