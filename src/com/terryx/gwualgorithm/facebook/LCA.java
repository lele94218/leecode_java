package com.terryx.gwualgorithm.facebook;

import com.terryx.main.TreeNode;
import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 10/15/17 1:30 PM.
 */
public class LCA {
    // LCA for BST

    /**
     * Recursion. Worst O(n) Best O(log n)
     */
    public TreeNode LCAForBST0(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if (root.val > q.val) {
            return LCAForBST0(root.left, p, q);
        } else if (root.val < p.val) {
            return LCAForBST0(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * Iteration
     */
    public TreeNode LCAForBST1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root.val > q.val || root.val < p.val) {
            if (root.val > q.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }


    //LCA for Binary Tree
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    /**
     * 给一个二叉树, 求最深节点的最小公共父节点
     * Example:
     *
     * [1,2,3,null,null,5,6]
     * return 3.
     *
     * [1,2,3,4,null,5,6]
     * return 1.
     *
     * Solve it using both recursive and iterative.
     */
    public TreeNode LCADeepestRecursive(TreeNode root) {
        return helper(root).node;
    }

    private Info helper(TreeNode root) {
        if (root == null) {
            return new Info(0, null);
        }
        Info left = helper(root.left);
        Info right = helper(root.right);
        if (left.height == right.height) {
            return new Info(left.height + 1, root);
        } else {
            return new Info(Math.max(left.height, right.height) + 1,
                    (left.height > right.height ? left.node : right.node));
        }
    }

    /**
     * Simulate call stack
     */
    public TreeNode LCADeepestIterative(TreeNode root) {
        Deque<Slice> stack = new ArrayDeque<>();
        stack.push(new Slice(root, null, null, 0));
        Info retVal = null;
        while (!stack.isEmpty()) {
            Slice cur = stack.pop();
            TreeNode curRoot = cur.root;
            Info curLeft = cur.leftInfo;
            Info curRight = cur.rightInfo;
            int first = cur.first;
            // exit condition
            if (curRoot == null) {
                retVal = new Info(0, null);
                continue;
            }
            if (first == 0) {
                // do left
                stack.push(new Slice(curRoot, curLeft, curRight, 1));
                stack.push(new Slice(curRoot.left, curLeft, curRight, 0));
            } else if (first == 1) {
                curLeft = retVal;
                // do right
                stack.push(new Slice(curRoot, curLeft, curRight, 2));
                stack.push(new Slice(curRoot.right, curLeft, curRight, 0));
            } else {
                curRight = retVal;
                // get result
                if (curLeft.height == curRight.height) {
                    retVal = new Info(curLeft.height + 1, curRoot);
                } else {
                    retVal = new Info(Math.max(curLeft.height, curRight.height) + 1,
                            (curLeft.height > curRight.height ? curLeft.node : curRight.node));
                }
            }
        }
        return retVal.node;
    }

    public class Slice {
        // each slice of stack contains {root, leftInfo, rightInfo}
        TreeNode root;
        Info leftInfo, rightInfo;
        int first;

        Slice(TreeNode root, Info leftInfo, Info rightInfo, int first) {
            this.root = root;
            this.leftInfo = leftInfo;
            this.rightInfo = rightInfo;
            this.first = first;
        }
    }

    static class Info {
        int height;
        TreeNode node;

        public Info(int height, TreeNode node) {
            this.height = height;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        LCA i = new LCA();
        TreeNode root;
        root = Utils.genTree("[1,2,3,null,null,5,6]");
        System.out.println(i.LCADeepestRecursive(root).val);
        root = Utils.genTree("[1,2,3,4,null,5,6]");
        System.out.println(i.LCADeepestRecursive(root).val);


        root = Utils.genTree("[1,2,3,null,null,5,6]");
        System.out.println(i.LCADeepestIterative(root).val);
        root = Utils.genTree("[1,2,3,4,null,5,6]");
        System.out.println(i.LCADeepestIterative(root).val);
    }
}
