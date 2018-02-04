package com.terryx.leecode.problem;

/**
 * @author taoranxue on 7/25/17 4:28 PM.
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        int sortIdx = 0;
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i] > nums[i - 1]) {
                int swap = nums[i];
                int swapIdx = i;
                sortIdx = i;
                for (int j = i; j < nums.length; ++j) {
                    if (nums[j] > nums[i - 1] && nums[j] < swap) {
                        swapIdx = j;
                        swap = nums[j];
                    }
                }
                int tmp = nums[i - 1];
                nums[i - 1] = nums[swapIdx];
                nums[swapIdx] = tmp;
                break;
            }
        }

        for (int i = sortIdx; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

    }
}
