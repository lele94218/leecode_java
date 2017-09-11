package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/11/17 6:55 PM.
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, res, "");
        return res;
    }

    private void helper(TreeNode cur, List<String> ans, String str) {
        if (cur == null) return;
        if (cur.left == null && cur.right == null) {
            ans.add(str + cur.val);
            return;
        }
        helper(cur.left, ans, str + cur.val + "->");
        helper(cur.right, ans, str + cur.val + "->");
    }
}
