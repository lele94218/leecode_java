package com.terryx.leecode;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 6/5/17 6:42 PM.
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left, right;
        left = right = root;
        int depth = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            depth ++;
        }
        if (left == null)
            return (1 << depth) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
