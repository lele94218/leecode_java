package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/25/17 7:37 PM.
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int heights[] = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int j = 0; j < heights.length; ++j) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[j]) {
                    res = Math.max(res, heights[stack.pop()] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
            while (stack.peek() != -1) {
                res = Math.max(res, heights[stack.pop()] * (heights.length - stack.peek() - 1));
            }
        }
        return res;
    }
}
