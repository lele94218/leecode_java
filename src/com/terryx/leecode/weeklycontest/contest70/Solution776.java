package com.terryx.leecode.weeklycontest.contest70;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 2/3/18 9:45 PM.
 */
public class Solution776 {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        TreeNode[] res;
        if (root.val <= V) {
            res = splitBST(root.right, V);
            root.right = res[0];
            res[0] = root;
        } else {
            res = splitBST(root.left, V);
            root.left = res[1];
            res[1] = root;
        }
        return res;
    }
}
