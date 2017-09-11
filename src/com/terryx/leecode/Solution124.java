package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/11/17 12:55 PM.
 */
public class Solution124 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode cur) {
        if (cur == null) return 0;
        int left = Math.max(0, dfs(cur.left));
        int right = Math.max(0, dfs(cur.right));
        res = Math.max(res, left + right + cur.val);
        return Math.max(left, right) + cur.val;
    }
}
