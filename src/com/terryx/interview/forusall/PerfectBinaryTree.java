package com.terryx.interview.forusall;

import com.terryx.main.TreeNode;
import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 2/3/18 1:33 PM.
 */
public class PerfectBinaryTree {
    int res = 0;

    public int largestCompleteTree(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, 2 * Math.min(left, right) + 1);
        return 2 * Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode t = Utils.genTree("[1,2,3,null,4,5,6,null,null,7,8,9,10,null,null,null,null,null,null,11,null]");
        PerfectBinaryTree m = new PerfectBinaryTree();
        System.out.println(m.largestCompleteTree(t));
    }
}
