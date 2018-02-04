package com.terryx.leecode.problem;

import com.terryx.main.Utils;

/**
 * @author taoranxue on 9/23/16 2:52 AM.
 */
public class Solution215 {
    private int quickSelect(int nums[], int left, int right, int k) {
        // if (left <= right) {
        //     int pivot = partition(nums, left, right);
        //     if (k == pivot) {
        //         return nums[pivot];
        //     }
        //     if (k > pivot) return quickSelect(nums, pivot, right, k);
        //     else return quickSelect(nums, left, pivot - 1, k);
        // }
        // return -1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (k == pivot) {
                return nums[pivot];
            }
            if (k > pivot) {
                left = pivot;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }

    private int partition(int nums[], int left, int right) {
        int x = nums[right];
        int i = left;
        for (int j = left; j < right; ++j) {
            if (nums[j] >= x) {
                swap(nums, i, j);
                ++i;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length <= 1) return nums[0];
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }
}
