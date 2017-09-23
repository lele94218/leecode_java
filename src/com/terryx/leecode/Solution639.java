package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/23/17 5:19 PM.
 */
public class Solution639 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        long dp[] = new long[s.length() + 1];
        dp[s.length()] = 1;
        if (s.charAt(s.length() - 1) == '*') {
            dp[s.length() - 1] = 9;
        } else if (s.charAt(s.length() - 1) != '0') {
            dp[s.length() - 1] = 1;
        }
        for (int i = s.length() - 2; i >= 0; --i) {
            char c0 = s.charAt(i), c1 = s.charAt(i + 1);
            long tmp = 0;
            if (c0 == '*' && c1 == '*') {
                tmp += (9 * dp[i + 1]) % 1000000007;
                tmp += (15 * dp[i + 2]) % 1000000007;
            } else if (c0 == '*') {
                tmp += 9 * dp[i + 1];
                int a = c1 - '0';
                if (a >= 0 && a <= 6) tmp += (2 * dp[i + 2]) % 1000000007;
                if (a >= 7 && a <= 9) tmp += dp[i + 2];
            } else if (c1 == '*') {
                int a = c0 - '0';
                if (a != 0)
                    tmp += dp[i + 1];
                if (a == 1) {
                    tmp += (9 * dp[i + 2]) % 1000000007;
                }
                if (a == 2) {
                    tmp += (6 * dp[i + 2]) % 1000000007;
                }
            } else {
                int a = c0 - '0', b = c1 - '0';
                if (a != 0) {
                    tmp += dp[i + 1];
                }
                a = a * 10 + b;
                if (a <= 26 && a >= 10) {
                    tmp += dp[i + 2];
                }
            }
            tmp = (tmp + 1000000007) % 1000000007;
            dp[i] = tmp;
        }
        return (int) dp[0];
    }
}
