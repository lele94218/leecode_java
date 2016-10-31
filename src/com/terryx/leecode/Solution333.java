package com.terryx.leecode;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 10/30/16 9:11 PM.
 */
public class Solution333 {
    private class Tuple {
        int res;
        int min;
        int max;

        public Tuple(int res, int min, int max) {
            this.res = res;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        Tuple tuple = dfs(root);
        return Math.abs(tuple.res);
    }

    public Tuple dfs(TreeNode root) {
        if (root == null) return new Tuple(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Tuple left = dfs(root.left);
        Tuple right = dfs(root.right);
        if (left.res < 0 || right.res < 0 || root.val <= left.max || root.val >= right.min)
            return new Tuple(Math.max(Math.abs(left.res), Math.abs(right.res)) * -1, 0, 0);
        return new Tuple(left.res + right.res + 1, Math.min(root.val, left.min), Math.max(root.val, right.max));
    }


}
