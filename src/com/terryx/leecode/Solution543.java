package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/12/17 1:45 PM.
 */
public class Solution543 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = helper(root.left), right = helper(root.right);
        res = Math.max(res, left + right);
        return Math.max(right, left) + 1;

    }
}
