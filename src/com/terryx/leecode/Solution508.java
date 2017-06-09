package com.terryx.leecode;

import com.terryx.gwualgorithm.google.Interview1;
import com.terryx.main.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taoranxue on 6/8/17 7:53 PM.
 */
public class Solution508 {
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    private int subtreeSum(TreeNode cur) {
        if (cur == null) return 0;
        int sum = cur.val + subtreeSum(cur.left) + subtreeSum(cur.right);
        if (map.containsKey(sum)) {
            int cnt = map.get(sum) + 1;
            ++cnt;
            maxCount = Math.max(maxCount, cnt);
            map.put(sum, cnt);
        }
        else map.put(sum, 0);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        subtreeSum(root);
        List<Integer> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) res.add(key);
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); ++ i) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
