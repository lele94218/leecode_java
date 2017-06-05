package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taoranxue on 6/5/17 7:03 PM.
 */
public class Solution337 {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (map.containsKey(root)) return map.get(root);
        if (root == null) return 0;
        int res = Math.max(
                root.val + ((root.left == null) ? 0 : rob(root.left.left) + rob(root.left.right))
                         + ((root.right == null) ? 0 : rob(root.right.left) + rob(root.right.right)),
                rob(root.left) + rob(root.right));
        map.put(root, res);
        return res;
    }
}
