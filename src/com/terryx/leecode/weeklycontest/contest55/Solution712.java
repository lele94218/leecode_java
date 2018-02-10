package com.terryx.leecode.weeklycontest.contest55;

import java.util.*;

/**
 * @author taoranxue on 2/8/18 8:19 PM.
 */
public class Solution712 {
    int res = 0;

    public int minimumDeleteSum(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        int m = s1.length(), n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                }
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        int sum = 0;
        for (int i = 0; i < m; ++i) {
            sum += s1.charAt(i);
        }
        for (int i = 0; i < n; ++i) {
            sum += s2.charAt(i);
        }
        return sum - 2 * dp[m][n];
    }

    public static void main(String[] args) {
        Solution712 m = new Solution712();
        System.out.println(m.minimumDeleteSum("sea", "eat"));
        System.out.println(m.minimumDeleteSum("leet", "delete"));
        System.out.println(m.minimumDeleteSum("ccaccjp", "fwosarcwge"));
    }
}
