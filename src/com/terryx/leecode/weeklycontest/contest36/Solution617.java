package com.terryx.leecode.weeklycontest.contest36;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 6/10/17 9:31 PM.
 */
public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
