package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 10/18/16 3:28 AM.
 */
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result[] = new List[n + 1];
        result[0] = new ArrayList<>();
        if (n == 0) return result[n];
        result[0].add(null);
        for (int len = 1; len <= n; ++ len) {
            result[len] = new ArrayList<>();
            for (int head = 1; head <= len; ++ head) {
                for (TreeNode lChild : result[head - 1]) {
                    for (TreeNode rChild : result[len - head]) {
                        TreeNode root = new TreeNode(head);
                        root.left = lChild;
                        root.right = treeOffset(rChild, head);
                        result[len].add(root);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode treeOffset(TreeNode root, int offset) {
        if (root == null || offset == 0) return root;
        TreeNode _root = new TreeNode(root.val + offset);
        _root.left = treeOffset(root.left, offset);
        _root.right = treeOffset(root.right, offset);
        return _root;
    }
}
