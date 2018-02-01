package com.terryx.interview.facebook;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/21/17 6:24 PM.
 */
public class MonotonicStack {
    /**
     * 结合栈内元素的单调性，我们知道左边的边框是栈顶的元素+1，栈顶元素所对应的bar一定比出栈元素对应的bar小，
     * 所以以出栈元素对应的bar为高的矩形无法往左边延展。结合代码，我们知道右边的边框是正在处理的i，
     * 因为我们已经判断过这个第i个元素所对应的bar也一定比出栈元素对应的bar小，所以矩形无法往右边延展。
     * 这个元素和左右边框之间如果还有空隙，那么这些空隙里所存在的bar，一定是因为维护栈的单调性而被弹出了。
     * 换言之，这些bar如果存在，那么一定比这个出栈元素所对应的bar高。
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                res = Math.max(res, heights[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res = Math.max(res, heights[stack.pop()] * (stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1));
        }
        return res;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int heights[] = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                heights[j] = (matrix[i][j] == '0' ? 0 : 1 + heights[j]);
            }
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < matrix[i].length; ++j) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[j]) {
                    res = Math.max(res, heights[stack.pop()] * (stack.isEmpty() ? j : j - stack.peek() - 1));
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                res = Math.max(res, heights[stack.pop()] * (stack.isEmpty() ? matrix[i].length : matrix[i].length - stack.peek() - 1));
            }
        }
        return res;
    }

    /**
     * Cartesian tree:
     * Given an integer array with no duplicates. A max tree building on this array is defined as follow:
     * The root is the maximum number in the array The left subtree and right subtree are the max trees of
     * the subarray divided by the root number. Construct the max tree by the given array.
     * Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:
     * 6
     * / \
     * 5   3
     * /   / \
     * 2   0   1
     */
    public TreeNode maxTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            TreeNode node = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > stack.peek().val) {
                node.left = stack.pop();
            }

            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
        }
        return root;
    }

    // Trapping Rain Water
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

    /**
     * 给出挡板长度，求最大蓄水面积。Two pointers.
     * Example:
     *
     * [1,3,2,4,1,2,3]
     *
     * +      |
     * +  |   |     |
     * +  | | |   | |
     * +| | | | | | |
     * +0+1+2+3+4+5+6
     *
     * Output [3,6] -> Area is 9
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MonotonicStack i = new MonotonicStack();
        System.out.println(i.maxTree(new int[]{2, 5, 6, 0, 3, 1, 4}));
    }

}
