package com.terryx.leecode.weeklycontest.contest54;

import java.util.*;

/**
 * @author taoranxue on 2/9/18 7:45 PM.
 */
public class Solution698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        int part = sum / k;
        Map<Integer, Boolean> map = new HashMap<>();
        return dfs(nums, 0, part, 0, k, part, map);
    }

    private boolean dfs(int[] nums, int bit, int remain, int cnt, int k, int p, Map<Integer, Boolean> map) {
        boolean res = false;
        if (map.containsKey(bit)) {
            return map.get(bit);
        }
        if (cnt == k) {
            res = true;
        } else {
            boolean flag = false;
            for (int i = 0; i < nums.length; ++i) {
                if ((bit & (1 << i)) == 0) {
                    if (remain == nums[i]) {
                        flag = dfs(nums, bit | (1 << i), p, cnt + 1, k, p, map);
                    } else if (remain > nums[i]) {
                        flag = dfs(nums, bit | (1 << i), remain - nums[i], cnt, k, p, map);
                    }
                    if (flag) {
                        res = true;
                        break;
                    }
                }
            }
        }
        map.put(bit, res);
        return res;
    }

    public static void main(String[] args) {
        Solution698 m = new Solution698();
        System.out.println(m.canPartitionKSubsets(
                new int[]{605, 454, 322, 218, 8, 19, 651, 2220, 175, 710, 2666, 350, 252, 2264, 327, 1843}, 4));
    }
}
