package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/11/17 1:16 PM.
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }

    private boolean isSym(TreeNode cur1, TreeNode cur2) {
        if (cur1 == null && cur2 == null) return true;
        if (cur1 == null || cur2 == null) return false;
        if (cur1.val != cur2.val) return false;
        if (cur1 == cur2) {
            return isSym(cur1.left, cur2.right);
        }
        return isSym(cur1.left, cur2.right) && isSym(cur1.right, cur2.left);
    }
}
