package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.Stack;

/**
 * @author taoranxue on 6/3/17 9:02 PM.
 */
public class Solution173 {
    public class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public void pushAll(TreeNode cur) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode tmp = stack.pop();
            pushAll(tmp.right);
            return tmp.val;
        }
    }
}
