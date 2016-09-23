package com.terryx.leecode;

import java.util.Arrays;

/**
 * @author taoranxue on 9/23/16 12:31 AM.
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
//        int max = 1, cur = nums[0], _max = 0;
//        int major = cur;
//        for (int i = 0; i < nums.length; ++i) {
//            if (nums[i] == cur) _max++;
//            else {
//                if (max < _max) {
//                    max = _max;
//                    major = nums[i - 1];
//                }
//                cur = nums[i];
//                _max = 1;
//            }
//        }
//        if (max < _max) {
//            max = _max;
//            major = nums[nums.length - 1];
//        }
        return nums[nums.length / 2];
    }
}
