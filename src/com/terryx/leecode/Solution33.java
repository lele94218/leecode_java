package com.terryx.leecode;

import java.util.Arrays;

/**
 * @author taoranxue on 7/25/17 4:28 PM.
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int offset = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                offset = i;
                break;
            }
        }
        int low = 0;
        int high = nums.length - 1;
        int len = nums.length;
        int ret = -1;
        // System.out.println(offset);
        while (low <= high) {
            int mid = (low + high) >> 1;
            int midVal = nums[(mid + offset) % len];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                ret = (mid + offset) % len;
                break;
            }
        }
        return ret;
    }
}
