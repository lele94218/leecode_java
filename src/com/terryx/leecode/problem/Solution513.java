package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 6/8/17 8:09 PM.
 */
public class Solution513 {
    int maxDepth = 0;
    int ans = -1;
    public void dfs(TreeNode cur, int depth) {
        if (maxDepth < depth) {
            maxDepth = depth;
            ans = cur.val;
        }
        if (cur.left != null) dfs(cur.left, depth + 1);
        if (cur.right != null) dfs(cur.right, depth + 1);
    }
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        dfs(root, 1);
        return ans;
    }
}
