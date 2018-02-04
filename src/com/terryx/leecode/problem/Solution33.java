package com.terryx.leecode.problem;

import java.util.Arrays;

/**
 * @author taoranxue on 7/25/17 4:28 PM.
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] >= nums[high]) {
                if (target < nums[mid] && target >= nums[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
