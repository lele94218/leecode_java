package com.terryx.leecode;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 10/30/16 8:21 PM.
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if (root.val >= p.val && root.val <= q.val) return root;
        if (root.val >= p.val && root.val >= q.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
