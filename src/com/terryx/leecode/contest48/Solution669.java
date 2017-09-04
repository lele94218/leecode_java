package com.terryx.leecode.contest48;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/2/17 9:37 PM.
 */
public class Solution669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
