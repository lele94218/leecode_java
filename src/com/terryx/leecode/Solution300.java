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
                int low = 0;
                int high = stack.size() - 1;
                while (low <= high) {
                    int mid = (low + high) >> 1;
                    if (stack.get(mid) < num) {
                        low = mid + 1;
                    } else if (stack.get(mid) > num) {
                        high = mid - 1;
                    } else {
                        low = mid;
                        break;
                    }
                }
                stack.set(low, num);
            }
        }
        return stack.size() - 1;
    }
}
