package com.terryx.leecode.problem;

/**
 * @author taoranxue on 10/18/16 1:20 AM.
 */
public class Solution91 {
    public int numDecodings1(String s) {
        if (s.equals("")) return 0;
        int n = s.length();
        int[] a = new int[n + 1];
        a[n] = 1;
        a[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; --i) {
            if (s.charAt(i) == '0') continue;
            int c = Integer.parseInt(s.substring(i, i + 2));
            if (c > 0 && c <= 26) a[i] = a[i + 1] + a[i + 2];
            else a[i] = a[i + 1];
        }
        return a[0];
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int dp[] = new int[s.length() + 1];
        int a = s.charAt(s.length() - 1) - '0';
        dp[s.length()] = 1;
        dp[s.length() - 1] = (a > 0 && a <= 9) ? 1 : 0;
        for (int i = s.length() - 2; i >= 0; -- i) {
            int n0 = Integer.parseInt(s.substring(i, i + 1)), n1 = Integer.parseInt(s.substring(i, i + 2));
            if (n0 > 0 && n0 <= 9) {
                dp[i] += dp[i + 1];
            }
            if (n1 >= 10 && n1 <= 26) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}
