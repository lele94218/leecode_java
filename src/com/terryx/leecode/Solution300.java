package com.terryx.leecode;

import java.util.Collections;
import java.util.Stack;

/**
 * @author taoranxue on 10/20/16 9:27 PM.
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);
        for (int num : nums) {
            if (num > stack.peek()) {
                stack.push(num);
            } else {
                Collections.binarySearch(stack, num);
            }
        }
        return -1;
    }
}
