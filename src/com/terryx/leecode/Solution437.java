package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/12/17 5:08 PM.
 */
public class Solution437 {

    //     public int pathSum(TreeNode root, int sum) {
//         return helper(root, sum, sum, false);
//     }

    //     private int helper(TreeNode root, int sum, int init, boolean chosen) {
//         if (root == null) return 0;
//         int ret = 0;
//         if (root.val == sum) {
//             ret += 1;
//         }
//         if (chosen) {
//             // chosen
//             ret += helper(root.left, sum - root.val, init, true) + helper(root.right, sum - root.val, init, true);
//         } else {
//             // not chosen
//             ret += helper(root.left, sum - root.val, init, true) + helper(root.right, sum - root.val, init, true)
//                 + helper(root.left, init, init, false) + helper(root.right, init, init, false);
//         }
//         return ret;
//     }

    // Quick version using hash map
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int ret = 0;
        sum += root.val;
        if (map.containsKey(sum - target)) {
            ret += map.get(sum - target);
        }
        int v = 1;
        if (map.containsKey(sum)) {
            v = map.get(sum) + 1;
        }
        map.put(sum, v);
        ret += helper(root.left, sum, target, map) + helper(root.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return ret;
    }
}
