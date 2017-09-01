package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/1/17 12:11 PM.
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (val != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
