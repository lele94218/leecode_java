package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/13/17 11:40 AM.
 */
public class Solution404 {
    int cnt = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return cnt;
    }
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left), ret = 0;
        if (root.left == null && root.right == null) {
            ret = root.val;
        }
        cnt += left;
        helper(root.right);
        return ret;
    }
}
