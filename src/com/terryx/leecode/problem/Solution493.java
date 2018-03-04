package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 3/3/18 6:27 PM.
 */
public class Solution493 {
    public int reversePairs(int[] nums) {
        int res = mergeCount(nums, new int[nums.length], 0, nums.length - 1);
        return res;
    }

    private int mergeCount(int[] nums, int[] back, int start, int end) {
        if (start >= end) return 0;
        int cnt = 0, mid = (start + end) / 2;
        cnt += mergeCount(nums, back, start, mid);
        cnt += mergeCount(nums, back, mid + 1, end);
        for (int i = start; i <= end; ++i) back[i] = nums[i];
        int j = mid + 1;
        for (int i = start; i <= mid; ++i) {
            while (j <= end && (long) back[i] > 2l * (long) back[j]) j++;
            cnt += (j - mid - 1);
        }
        int index = start, left = start, right = mid + 1;
        while (index <= end) {
            if (left <= mid && (right > end || back[left] <= back[right])) {
                nums[index++] = back[left++];
            } else {
                nums[index++] = back[right++];
            }
        }
        return cnt;
    }
}
