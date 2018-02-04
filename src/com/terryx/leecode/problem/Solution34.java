package com.terryx.leecode.problem;

/**
 * @author xueta on 8/24/2016 6:25 PM.
 *         Given a sorted array of integers, find the starting and ending position of a given target value.
 *         <p>
 *         Your algorithm's runtime complexity must be in the order of O(log n).
 *         <p>
 *         If the target is not found in the array, return [-1, -1].
 *         <p>
 *         For example,
 *         Given [5, 7, 7, 8, 8, 10] and target value 8,
 *         return [3, 4].
 *         <p>
 *         Subscribe to see which companies asked this question
 */
public class Solution34 {
    public static int[] searchRange(int[] nums, int target) {
        boolean flag = false;
        for (int num : nums) {
            if (num == target) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        int mid = (l + r) >> 1;
        while (l < r) {
            if (nums[mid] < target) {
                if (l == mid) {
                    l = mid + 1;
                } else {
                    l = mid;
                }
                mid = (l + r) >> 1;
            } else if (nums[mid] > target) {
                if (r == mid) {
                    r = mid - 1;
                } else {
                    r = mid;
                }
                mid = (l + r) >> 1;
            } else {
                l = mid;
                break;
            }
        }
        for (int i = l; i < nums.length; ++i) {
            if (nums[mid] == nums[i]) {
                r = i;
            }
        }
        for (int i = l; i >= 0; -- i) {
            if (nums[mid] == nums[i]) {
                l = i;
            }
        }
        return new int[]{l, r};
    }

}
