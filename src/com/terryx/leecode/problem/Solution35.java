package com.terryx.leecode.problem;

/**
 * @author xueta on 8/24/2016 8:17 PM.
 */
public class Solution35 {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l ) >> 1);
            if (nums[mid] < target) {
                if (l == mid) l = mid + 1;
                else l = mid;
            } else if (nums[mid] > target) {
                if (l == mid) r = mid - 1;
                else r = mid;
            } else {
                l = mid;
                break;
            }
        }
        if (l == nums.length - 1 && nums[l] < target) return nums.length;
        if (l == 0 && nums[l] > target) return 0;
        return l;
    }
}
