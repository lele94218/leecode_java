package com.terryx.leecode.classic.tree;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 10/7/17 7:26 PM.
 */
public class JudgeBST {
    public boolean isBST(TreeNode root) {
        // Write your solution here.
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int left, int right) {
        if (root == null) return true;
        if (root.val <= left || root.val >= right) return false;
        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }
}
