package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/25/17 6:31 PM.
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                res = Math.max(res, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            res = Math.max(res, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return res;
    }
}
