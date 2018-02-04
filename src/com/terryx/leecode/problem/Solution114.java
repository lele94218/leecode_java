package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 10/30/16 8:00 PM.
 */
public class Solution114 {
    /**
     * Recursive version
     */
    public void flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        helper(root, prev);
    }

    private void helper(TreeNode root, TreeNode prev[]) {
        if (root == null) {
            return;
        }
        helper(root.right, prev);
        helper(root.left, prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }

    /**
     * Tail recursion
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            TreeNode tmp = root.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = root.right;
        }
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

    /**
     * Easily convert to iterative
     */
    public void flatten2(TreeNode root) {
        while (root != null) {
            if (root.left != null && root.right != null) {
                TreeNode tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = root.right;
            }
            if (root.left != null) {
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
