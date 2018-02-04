package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/23/17 10:59 PM.
 */
public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= small) small = nums[i];
            else if (nums[i] <= big) big = nums[i];
            else return true;
        }
        return false;
    }
}
