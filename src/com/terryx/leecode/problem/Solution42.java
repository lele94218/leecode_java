package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 10/21/17 8:26 PM.
 */
public class Solution42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                res += width * (Math.min(height[i], height[stack.peek()]) - height[top]);
            }
            stack.push(i);
        }
        return res;
    }
}
