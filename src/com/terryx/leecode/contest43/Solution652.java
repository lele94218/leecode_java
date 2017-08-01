package com.terryx.leecode.contest43;

import com.terryx.main.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author taoranxue on 8/1/17 5:09 PM.
 */
public class Solution652 {
    ArrayList<TreeNode> res = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    public String dfs(TreeNode root) {
        if (root == null) return "-";
        String str = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        Integer v = null;
        if ((v = map.get(str)) == null) {
            map.put(str, 1);
        } else if (v == 1) {
            map.put(str, 2);
            res.add(root);
        }
        return str;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }
}
