package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/11/17 6:47 PM.
 */
public class Solution99 {
    private TreeNode error0 = null, error1 = null, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        findMistake(root);
        int tmp = error0.val;
        error0.val = error1.val;
        error1.val = tmp;
    }


    public void findMistake(TreeNode cur) {
        if (cur == null) return;
        findMistake(cur.left);

        if (error0 == null && prev.val >= cur.val) {
            error0 = prev;
        }
        if (error0 != null && prev.val >= cur.val) {
            error1 = cur;
        }
        prev = cur;

        findMistake(cur.right);
    }
}
