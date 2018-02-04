package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 6/1/17 8:34 PM.
 */
public class Solution113 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pa = new ArrayList<>();

    public void dfs(int n, TreeNode cur) {

        if (cur.right != null) {
            pa.add(cur.right.val);
            dfs(n - cur.val, cur.right);
            pa.remove(pa.size() - 1);
        }

        if (cur.left != null) {
            pa.add(cur.left.val);
            dfs(n - cur.val, cur.left);
            pa.remove(pa.size() - 1);
        }

        if (cur.right == null && cur.left == null && n == cur.val) {
            res.add(new ArrayList<>(pa));
        }

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        pa.add(root.val);
        dfs(sum, root);
        return res;
    }
}
