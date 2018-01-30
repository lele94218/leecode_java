package com.terryx.leecode.weeklycontest.contest35;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 6/3/17 9:44 PM.
 */
public class Solution606 {
    StringBuilder sb = new StringBuilder("");
    public void dfs(TreeNode cur) {
        sb.append(cur.val);
        if (cur.left != null) {
            sb.append("(");
            dfs(cur.left);
            sb.append(")");
        }
        if (cur.left == null && cur.right != null) {
            sb.append("()");
        }

        if (cur.right != null) {
            sb.append("(");
            dfs(cur.right);
            sb.append(")");
        }

    }

    public String tree2str(TreeNode t) {
        if (t == null) return sb.toString();
        dfs(t);
        return sb.toString();
    }
}
