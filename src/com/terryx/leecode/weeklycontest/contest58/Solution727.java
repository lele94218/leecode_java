package com.terryx.leecode.weeklycontest.contest58;


import java.util.*;

/**
 * @author taoranxue on 1/30/18 11:28 PM.
 */
public class Solution727 {
    public String minWindow(String S, String T) {
        if (S == null || T == null) {
            return "";
        }
        int dp[][] = new int[T.length()][S.length()];
        for (int i = 0; i < T.length(); ++i) {
            int last = -1;
            for (int j = 0; j < S.length(); ++j) {
                if (i == 0) {
                    if (T.charAt(i) == S.charAt(j)) {
                        dp[i][j] = j;
                    } else {
                        dp[i][j] = -1;
                    }
                } else {
                    dp[i][j] = -1;
                    if (last >= 0 && T.charAt(i) == S.charAt(j)) {
                        dp[i][j] = last;
                    }
                    if (dp[i - 1][j] >= 0) {
                        last = dp[i - 1][j];
                    }
                }
            }
        }
        int len = Integer.MAX_VALUE;
        String res = "";
        for (int j = 0; j < S.length(); ++j) {
            if (S.charAt(j) == T.charAt(T.length() - 1)) {
                int start = dp[T.length() - 1][j];
                if (start >= 0 && j - start + 1 < len) {
                    len = j - start + 1;
                    res = S.substring(start, j + 1);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution727 m = new Solution727();
        System.out.println(m.minWindow("abcdebdde", "bde"));
        System.out.println(m.minWindow("fweekpamjwqobhxiesgzivminqqjjkgnhkdxpfjvvgfcdlgwvwtdwizpjcuwnwpioxcshyjglqjnkluedopzyhozjzqnjentspwffoawwbgyhrrapncwetqulmaupkkwugkpfztgejujlakrnkvefbvncfzhhmciztzjzrzrzlcfkejmlkhlogtraexhgrvxitcnaacegjrkwbseomwvdawsymemhsvtqcpbfvinhngdvhnrswwgoff",
                "qkkwtlzbbn"));
    }
}
