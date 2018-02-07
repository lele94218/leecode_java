package com.terryx.leecode.weeklycontest.contest56;

import java.util.*;

/**
 * @author taoranxue on 2/6/18 11:40 PM.
 */
public class Solution718 {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }

        int dp[][] = new int[A.length + 1][B.length + 1];
        int res = 0;
        for (int i = 1; i <= A.length; ++ i) {
            for (int j = 1; j <= B.length; ++ j) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
//                System.out.println(i + " " + j + ": " + dp[i][j]);
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution718 m = new Solution718();
        System.out.println(m.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }
}
