package com.terryx.leecode.weeklycontest.contest62;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 7:29 PM.
 */
public class Solution742 {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    Set<TreeNode> vist = new HashSet<>();
    int res = Integer.MAX_VALUE, key = 0;
    TreeNode kNode = null;

    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        dfs1(root, k);
        dfs2(kNode, 0);
        return key;
    }

    private void dfs1(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        if (root.val == k) {
            kNode = root;
        }

        if (root.left != null) {
            if (!map.containsKey(root)) {
                map.put(root, new ArrayList<>());
            }
            map.get(root).add(root.left);
            if (!map.containsKey(root.left)) {
                map.put(root.left, new ArrayList<>());
            }
            map.get(root.left).add(root);
            dfs1(root.left, k);
        }

        if (root.right != null) {
            if (!map.containsKey(root)) {
                map.put(root, new ArrayList<>());
            }
            map.get(root).add(root.right);
            if (!map.containsKey(root.right)) {
                map.put(root.right, new ArrayList<>());
            }
            map.get(root.right).add(root);
            dfs1(root.right, k);
        }
    }

    private void dfs2(TreeNode cur, int depth) {
        vist.add(cur);
        if (cur.left == null && cur.right == null) {
            //System.out.println(depth);
            if (depth < res) {
                res = depth;
                key = cur.val;
            }
            return;
        }
        for (TreeNode to : map.get(cur)) {
            if (!vist.contains(to)) {
                dfs2(to, depth + 1);
            }
        }
    }
}
