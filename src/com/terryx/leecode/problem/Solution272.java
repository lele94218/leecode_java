package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 2/25/18 2:08 PM.
 */
public class Solution272 {
    // O(n)
    public List<Integer> closestKValues1(TreeNode root, double target, int k) {
        LinkedList res = new LinkedList<>();
        solve(root, target, k, res);
        return res;
    }

    private boolean solve(TreeNode root, double target, int k, LinkedList<Integer> res) {
        if (root == null) return false;
        boolean r = solve(root.left, target, k, res);
        if (r) {
            return true;
        }
        if (res.size() == k) {
            if (Math.abs(res.peekFirst() - target) <= Math.abs(root.val - target)) {
                return true;
            }
            res.pollFirst();
        }
        res.offerLast(root.val);
        solve(root.right, target, k, res);
        return false;
    }


    // O(log n + k)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<TreeNode> greater = new ArrayDeque<>(), less = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null) {
            // System.out.println(cur.val);
            if (cur.val < target) {
                less.push(cur);
                cur = cur.right;
            } else {
                greater.push(cur);
                cur = cur.left;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (k > 0) {
            if (greater.isEmpty() && less.isEmpty()) {
                break;
            } else if (greater.isEmpty()) {
                list.add(lessNext(less));
            } else if (less.isEmpty()) {
                list.add(greaterNext(greater));
            } else if (Math.abs(less.peek().val - target) < Math.abs(greater.peek().val - target)) {
                list.add(lessNext(less));
            } else {
                list.add(greaterNext(greater));
            }
            k--;
        }
        return list;
    }

    private int lessNext(Deque<TreeNode> stack) {
        TreeNode top = stack.pop();
        int r = top.val;
        top = top.left;
        while (top != null) {
            stack.push(top);
            top = top.right;
        }
        return r;
    }

    private int greaterNext(Deque<TreeNode> stack) {
        TreeNode top = stack.pop();
        int r = top.val;
        top = top.right;
        while (top != null) {
            stack.push(top);
            top = top.left;
        }
        return r;
    }
}
