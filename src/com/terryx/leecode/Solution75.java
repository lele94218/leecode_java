package com.terryx.leecode;

/**
 * @author taoranxue on 8/4/17 5:10 PM.
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = nums.length - 1, k = i;
        while (i < j && k >= i && k <= j) {
            if (nums[k] == 0) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                ++i;
                if (k < i) k = i;
            } else if (nums[k] == 2) {
                int tmp = nums[j];
                nums[j] = nums[k];
                nums[k] = tmp;
                --j;
            } else {
                ++k;
            }
        }
    }
}
