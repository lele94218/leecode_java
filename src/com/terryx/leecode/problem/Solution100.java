package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/11/17 12:19 PM.
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
}
