package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/13/17 11:13 AM.
 */
public class Solution654 {
    // recursion O(n^2)
//     public TreeNode constructMaximumBinaryTree(int[] nums) {
//         if (nums == null || nums.length == 0) return null;
//         return helper(nums, 0, nums.length - 1);
//     }

//     private TreeNode helper(int[] nums, int left, int right) {
//         if (left > right) return null;
//         int index = left, max = nums[left];
//         for (int i = left; i <= right; ++ i) {
//             if (nums[i] > max) {
//                 max = nums[i];
//                 index = i;
//             }
//         }
//         TreeNode root = new TreeNode(max);
//         root.left = helper(nums, left, index - 1);
//         root.right = helper(nums, index + 1, right);
//         return root;
//     }

    // stack O(n)
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < nums.length; ++i) {
            TreeNode cur = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                cur.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
        return stack.get(0);
    }
}
