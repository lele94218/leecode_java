package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/8/17 12:23 PM.
 */
public class Solution462 {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int m = quickSelect(nums, nums.length / 2, 0, nums.length - 1), res = 0;
        // System.out.println(m);
        for (int i = 0; i < nums.length; ++i) {
            res += Math.abs(nums[i] - m);
        }
        return res;
    }

    private int quickSelect(int a[], int k, int start, int end) {
        while (start <= end) {
            int x = a[(start + end) / 2], pivot = start;
            swap(a, (start + end) / 2, end);
            for (int j = start; j < end; ++j) {
                if (a[j] < x) {
                    swap(a, j, pivot);
                    pivot++;
                }
            }
            swap(a, pivot, end);
            if (pivot == k) return a[k];
            if (k < pivot) end = pivot - 1;
            else start = pivot + 1;
        }
        return -1;
    }

    private void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
