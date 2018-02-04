package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/12/17 7:14 PM.
 */
public class Solution653 {
    static class BSTIterator {
        boolean min;
        Stack<TreeNode> stack;

        BSTIterator(TreeNode root, boolean min) {
            stack = new Stack<>();
            this.min = min;
            pushAll(root);
        }

        void pushAll(TreeNode cur) {
            while (cur != null) {
                stack.push(cur);
                cur = min ? cur.left : cur.right;
            }
        }

        TreeNode next() {
            TreeNode tmp = stack.pop();
            pushAll(min ? tmp.right : tmp.left);
            return tmp;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator sBST = new BSTIterator(root, true), lBST = new BSTIterator(root, false);
        TreeNode s = sBST.next(), l = lBST.next();
        while (s != l) {
            int sum = s.val + l.val;
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                s = sBST.next();
            } else {
                l = lBST.next();
            }
        }
        return false;
    }
}
