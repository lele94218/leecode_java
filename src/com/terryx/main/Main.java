package com.terryx.main;

import com.terryx.leecode.Solution1;
import com.terryx.leecode.Solution144;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    public static void main(String[] args) {
        Solution144 solution144 = new Solution144();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        solution144.preorderTraversal(root);
    }
}
