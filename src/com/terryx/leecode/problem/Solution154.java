package com.terryx.leecode.problem;

/**
 * @author taoranxue on 8/8/17 10:18 PM.
 */
public class Solution154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low < high) {
            if (nums[low] < nums[high]) return nums[low];
            mid = (low + high) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }
        return nums[low];
    }
}
