package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 10/30/16 12:21 AM.
 */
public class Solution298 {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return max;
        dfs(root, 1);
        return max;
    }

    private void dfs(TreeNode current, int len) {
        max = Math.max(max, len);
        TreeNode left = current.left;
        TreeNode right = current.right;
        if (left != null) {
            if (left.val == current.val + 1) dfs(left, len + 1);
            else dfs(left, 1);
        }
        if (right != null) {
            if (right.val == current.val + 1) dfs(right, len + 1);
            else dfs(right, 1);
        }
    }
}