package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.HashMap;

/**
 * @author taoranxue on 6/12/17 6:22 PM.
 */
public class Solution538 {
    int sum = 0;

    public void dfs(TreeNode cur) {
        if (cur == null) return;
        dfs(cur.right);
        cur.val = cur.val + sum;
        sum = cur.val;
        dfs(cur.left);
    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
}
