package com.terryx.leecode.weeklycontest.contest59;

/**
 * @author taoranxue on 1/29/18 6:04 PM.
 */
public class Solution730 {
    public int countPalindromicSubsequences(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        int len = S.length();
        int dp[][][] = new int[len][len][4];
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i; j < len; ++j) {
                for (int k = 0; k < 4; ++k) {
                    char c = (char) ('a' + k);
                    if (i == j) {
                        dp[i][j][k] = (S.charAt(i) == c) ? 1 : 0;
                    } else {
                        if (S.charAt(i) != c) {
                            dp[i][j][k] = dp[i + 1][j][k];
                        } else if (S.charAt(j) != c) {
                            dp[i][j][k] = dp[i][j - 1][k];
                        } else {
                            if (j == i + 1) {
                                dp[i][j][k] = 2;
                            } else {
                                dp[i][j][k] = 2;
                                for (int m = 0; m < 4; ++m) {
                                    dp[i][j][k] = (int) (((long) dp[i][j][k] + dp[i + 1][j - 1][m]) % 1000000007);
                                }
                            }
                        }
                    }
                    //System.out.println(i + " " + j + " " + c + " = " + dp[i][j][k]);
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 4; ++i) {
            res += dp[0][len - 1][i];
            res %= 1000000007;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution730 m = new Solution730();
        System.out.println(m.countPalindromicSubsequences("bccb"));
    }
}
