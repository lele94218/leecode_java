package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/11/17 12:15 PM.
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
