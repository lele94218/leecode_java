package com.terryx.leecode.contest48;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/2/17 9:37 PM.
 */
public class Solution669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        dfs(root, dummy, true, false, L, R);
        return dummy.left;
    }

    private void dfs(TreeNode cur, TreeNode preCur, boolean left, boolean right, int L, int R) {
        if (cur == null) return;
        TreeNode next = cur;
        if (cur.val < L) {
            next = cur.right;
            if (left) {
                preCur.left = cur.right;
                dfs(next, preCur, true, false, L, R);
            }

            if (right) {
                preCur.right = cur.right;
                dfs(next, preCur, false, true, L, R);
            }
        }

        if (cur.val > R) {
            next = cur.left;
            if (left) {
                preCur.left = cur.left;
                dfs(next, preCur, true, false, L, R);
            }

            if (right) {
                preCur.right = cur.left;
                dfs(next, preCur, false, true, L, R);
            }
        }
        if (next == cur) {
            dfs(next.left, next, true, false, L, R);
            dfs(next.right, next, false, true, L, R);
        }

    }
}
