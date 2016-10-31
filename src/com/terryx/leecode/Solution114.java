package com.terryx.leecode;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 10/30/16 8:00 PM.
 */
public class Solution114 {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

}
