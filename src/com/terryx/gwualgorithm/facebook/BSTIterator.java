package com.terryx.gwualgorithm.facebook;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/12/17 7:04 PM.
 */
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
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

    private void pushAll(TreeNode cur) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
}
