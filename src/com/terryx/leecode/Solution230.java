package com.terryx.leecode;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 8/28/16 2:03 PM.
 */
public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (count >= k) {
            return kthSmallest(root.left, k);
        }
        if (count < k - 1) {
            return kthSmallest(root.right, k - count - 1);
        }
        return root.val;
    }

    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
