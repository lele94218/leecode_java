package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/22/17 9:19 PM.
 */
public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean sameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val && sameTree(a.left, b.left) && sameTree(a.right, b.right);
    }
}
