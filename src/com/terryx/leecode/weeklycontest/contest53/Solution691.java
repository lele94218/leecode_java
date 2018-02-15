package com.terryx.leecode.weeklycontest.contest53;

import java.util.*;

/**
 * @author taoranxue on 2/15/18 3:09 PM.
 */
public class Solution691 {
    public int minStickers(String[] stickers, String target) {
        if (target == null || target.length() == 0) {
            return 0;
        }
        if (stickers == null || stickers.length == 0) {
            return -1;
        }
        int N = target.length();
        int dp[] = new int[1 << N];
        for (int i = 1; i < 1 << N; ++i) {
            dp[i] = -1;
        }

        for (int state = 0; state < 1 << N; ++state) {
            if (dp[state] == -1) {
                continue;
            }
            for (String sticker : stickers) {
                int next = state;
                for (int i = 0; i < sticker.length(); ++i) {
                    for (int j = 0; j < N; ++j) {
                        if (((next >> j) & 1) == 1) {
                            continue;
                        }
                        if (sticker.charAt(i) == target.charAt(j)) {
                            next |= (1 << j);
                            break;
                        }
                    }
                }
                if (dp[next] == -1 || dp[state] + 1 < dp[next]) {
                    dp[next] = dp[state] + 1;
                    //System.out.println(sticker + " " + Integer.toBinaryString(state) + " -> " + Integer.toBinaryString(next) + ": " + dp[next]);
                }
            }
        }

        return dp[(1 << N) - 1];
    }

    public static void main(String[] args) {
        Solution691 m = new Solution691();
        System.out.println(m.minStickers(new String[]{"with", "example", "science"}, "thehat"));
    }
}
