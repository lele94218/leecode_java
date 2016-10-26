package com.terryx.leecode;

/**
 * @author taoranxue on 10/24/16 10:41 PM.
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int a : nums) {
            res ^= a;
        }
        return res;
    }
}
