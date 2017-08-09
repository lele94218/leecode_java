package com.terryx.leecode;

/**
 * @author taoranxue on 8/8/17 10:37 PM.
 */
public class Solution162 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low < high) {
            mid = (low + high) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
