package com.terryx.leecode.lcode.tree;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/7/17 7:09 PM.
 */
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        if (left == -1) return -1;
        int right = height(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;

    }
}
