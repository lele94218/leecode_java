package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 6:06 PM.
 */
public class Solution280 {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            if ((i & 1) == 0 && nums[i] > nums[i + 1] || (i & 1) == 1 && nums[i] < nums[i + 1]) {
                swap(i, i + 1, nums);
            }
        }
    }

    private void swap(int i, int j, int a[]) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
