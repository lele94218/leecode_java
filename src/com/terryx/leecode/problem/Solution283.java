package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/13/17 8:52 PM.
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index++;
            }
        }
    }
}
