package com.terryx.leecode.contest36;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 6/10/17 9:31 PM.
 */
public class Solution617 {
    public void dfs(TreeNode cur1, TreeNode cur2) {
        cur1.val += cur2.val;

        if (cur1.left == null && cur2.left == null && cur1.right == null && cur2.right == null) return;

        if (cur1.left != null) {
            if (cur2.left == null) {
                cur2.left = new TreeNode(0);
            }
            dfs(cur1.left, cur2.left);
        }

        else if (cur2.left != null) {
            if (cur1.left == null) {
                cur1.left = new TreeNode(0);
            }
            dfs(cur1.left, cur2.left);
        }


        if (cur1.right != null) {
            if (cur2.right == null) {
                cur2.right = new TreeNode(0);
            }
            dfs(cur1.right, cur2.right);
        }
        else if (cur2.right != null) {
            if (cur1.right == null) {
                cur1.right = new TreeNode(0);
            }
            dfs(cur1.right, cur2.right);
        }

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) t1 = new TreeNode(0);
        if (t2 == null) t2 = new TreeNode(0);
        dfs(t1, t2);
        return t1;
    }
}
