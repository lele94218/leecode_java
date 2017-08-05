package com.terryx.leecode;

/**
 * @author taoranxue on 8/5/17 5:06 PM.
 */
public class Solution153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] < nums[high]) {
                return nums[low];
            }

            int mid = (low + high) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
