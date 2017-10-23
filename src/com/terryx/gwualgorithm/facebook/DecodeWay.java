package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/21/17 1:38 PM.
 */
public class DecodeWay {
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); ++i) {
            int c = s.charAt(i - 1) - '0';
            if (c > 0 && c <= 9) {
                dp[i] += dp[i - 1];
            }
            if (i > 1) {
                int pc = s.charAt(i - 2) - '0';
                int num = pc * 10 + c;
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        int a = (int) ((12L + 23L) / 4L);
        return dp[s.length()];
    }

    public int numDecodings2(String s) {
        final long MOD = 1000000007;
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); ++i) {
            char c = s.charAt(i - 1);
            if (c == '*') {
                dp[i] = (int) ((9L * dp[i - 1] + dp[i]) % MOD);
            } else if (c != '0') {
                dp[i] = (int) ((dp[i - 1] + dp[i] + 0L) % MOD);
            }
            if (i > 1) {
                char pc = s.charAt(i - 2);
                if (c == '*' && pc == '*') {
                    dp[i] = (int) ((15L * dp[i - 2] + dp[i]) % MOD);
                } else if (c == '*' && pc == '1') {
                    dp[i] = (int) ((9L * dp[i - 2] + dp[i]) % MOD);
                } else if (c == '*' && pc == '2') {
                    dp[i] = (int) ((6L * dp[i - 2] + dp[i]) % MOD);
                } else if (c != '*' && pc == '*') {
                    dp[i] = (c >= '0' && c <= '6' ? (int) ((2L * dp[i - 2] + dp[i]) % MOD) : (int) ((dp[i] + dp[i - 2] + 0L) % MOD));
                } else if (c != '*' && pc != '*') {
                    int num = (pc - '0') * 10 + c - '0';
                    if (num >= 10 && num <= 26) {
                        dp[i] = (int) ((dp[i - 2] + dp[i] + 0L) % MOD);
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
