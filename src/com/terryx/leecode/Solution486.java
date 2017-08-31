package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/31/17 2:43 PM.
 */
public class Solution486 {
    // dfs
//     public boolean PredictTheWinner(int[] nums) {
//         if (nums == null || nums.length == 0) return false;
//         Map<Integer, Boolean>[] maps = new Map[4096];
//         return dfs(0, nums.length - 1, nums, 1, 0, 0, maps);
//     }

//     private boolean dfs(int start, int end, int[] nums, int cur, int sum1, int sum2, Map<Integer, Boolean>[] maps) {
//         int hash = (start << 6) + end;
//         if (maps[hash] == null) maps[hash] = new HashMap<>();
//         if (maps[hash].containsKey((cur > 0) ? sum1 : sum2)) {
//             return maps[hash].get((cur > 0) ? sum1 : sum2);
//         }
//         if (start > end) {
//             if ((cur > 0) ? (sum1 >= sum2) : (sum1 < sum2) ) return true;
//             return false;
//         }
//         boolean ret = false;
//         // choose start
//         if (cur > 0)
//             ret = dfs(start + 1, end, nums, -cur, sum1 + nums[start], sum2, maps);
//         else
//             ret = dfs(start + 1, end, nums, -cur, sum1, sum2 + nums[start], maps);

//         if (!ret) {
//             maps[hash].put((cur > 0) ? sum1 : sum2, true);
//             return true;
//         }
//         if (start != end) {
//             // choose end
//             if (cur > 0)
//                 ret = dfs(start, end - 1, nums, -cur, sum1 + nums[end], sum2, maps);
//             else
//                 ret = dfs(start, end - 1, nums, -cur, sum1, sum2 + nums[end], maps);


//             if (!ret) {
//                 maps[hash].put((cur > 0) ? sum1 : sum2, true);
//                 return true;
//             }
//         }
//         maps[hash].put((cur > 0) ? sum1 : sum2, false);
//         return false;
//     }

    // DP
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int dp[][] = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            for (int j = i; j < nums.length; ++j) {
                if (i == j) dp[i][j] = nums[i];
                else dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
