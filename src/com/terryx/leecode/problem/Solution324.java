package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/29/17 11:16 PM.
 */
public class Solution324 {
    private int quickSelect(int nums[], int left, int right, int k) {
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
                i++;
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
        return quickSelect(nums, 0, nums.length - 1, k);
    }


    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        Arrays.sort(nums);
        int median = findKthLargest(nums, nums.length / 2), len = nums.length;
        int left = 0, right = len - 1, i = 0;
        while (i <= right) {
            if (nums[index(i, len)] < median) {
                swap(nums, index(i, len), index(right, len));
                --right;
            } else if (nums[index(i, len)] > median) {
                swap(nums, index(i, len), index(left, len));
                ++left;
                ++i;
            } else {
                ++i;
            }
        }
    }

    private int index(int i, int len) {
        return (2 * i + 1) % (len | 1);
    }
}
