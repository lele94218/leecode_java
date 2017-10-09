package com.terryx.leecode.lcode.tree;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/7/17 7:12 PM.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
