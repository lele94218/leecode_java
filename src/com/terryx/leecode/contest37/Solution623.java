package com.terryx.leecode.contest37;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 6/17/17 9:50 PM.
 */
public class Solution623 {
    public void dfs(TreeNode cur, TreeNode curPa, int v, int d, boolean left) {
        if (d == 1) {
            if (left) {
                if (curPa != null) {
                    curPa.left = new TreeNode(v);
                    curPa.left.left = cur;
                }
            } else {
                if (curPa != null) {
                    curPa.right = new TreeNode(v);
                    curPa.right.right = cur;
                }
            }
            return;
        }


        if (cur.left != null || d == 2) {
            dfs(cur.left, cur, v, d - 1, true);
        }

        if (cur.right != null || d == 2) {
            dfs(cur.right, cur, v, d - 1, false);
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return root;
        if (d == 1) {
            TreeNode res = new TreeNode(v);
            res.left = root;
            return res;
        }
        dfs(root, null, v, d, true);
        return root;
    }
}
