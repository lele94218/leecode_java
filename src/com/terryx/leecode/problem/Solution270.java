package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 2/24/18 6:36 PM.
 */
public class Solution270 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        if (Math.abs((double) root.val - target) < 1e-6) {
            return root.val;
        }
        if ((double) root.val < target && root.right != null) {
            int r = closestValue(root.right, target);
            if (Math.abs(target - (double) r) < Math.abs(target - (double) root.val)) {
                return r;
            }
            return root.val;
        } else if ((double) root.val > target && root.left != null) {
            int r = closestValue(root.left, target);
            if (Math.abs(target - (double) r) < Math.abs(target - (double) root.val)) {
                return r;
            }
            return root.val;
        }
        return root.val;
    }
}
