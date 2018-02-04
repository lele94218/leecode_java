package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 6/3/17 3:08 PM.
 */
public class Solution129 {
    int res = 0;

    public void dfs(TreeNode cur, int sum) {
        if (cur.left == null && cur.right == null) {
            res += (sum * 10 + cur.val);
            return;
        }
        if (cur.left != null)
            dfs(cur.left, sum * 10 + cur.val);
        if (cur.right != null)
            dfs(cur.right, sum * 10 + cur.val);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return  res;
        dfs(root, 0);
        return res;
    }
}
