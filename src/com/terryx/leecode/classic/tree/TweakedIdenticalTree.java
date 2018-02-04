package com.terryx.leecode.classic.tree;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 10/7/17 7:16 PM.
 */
public class TweakedIdenticalTree {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // Write your solution here.
        if (one == null || two == null) {
            return one == null && two == null;
        }
        if (one.val != two.val) return false;
        return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right) ||
                isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
    }
}
