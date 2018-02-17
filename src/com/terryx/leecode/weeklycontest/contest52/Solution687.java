package com.terryx.leecode.weeklycontest.contest52;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 2/16/18 6:31 PM.
 */
public class Solution687 {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);
        int res = Math.max(left, right);
        return Math.max(res, maxLengthWithVal(root.left, root.val) + maxLengthWithVal(root.right, root.val));
    }

    private int maxLengthWithVal(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        if (root.val != val) {
            return 0;
        }
        int left = maxLengthWithVal(root.left, val);
        int right = maxLengthWithVal(root.right, val);
        return Math.max(left, right) + 1;
    }
}
