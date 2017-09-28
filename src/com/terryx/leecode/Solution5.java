package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/19/17 2:44 PM.
 */
public class Solution5 {
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() == 0) return "";
        int maxLen = 0, start = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int len = 0; len < s.length(); ++len) {
            for (int i = 0; i < s.length() - len; ++i) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && maxLen < len + 1) {
                    maxLen = len + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        // O(n^2) Iteration
//         int start = 0, end = 0;
//         for (int i = 0; i < s.length(); ++ i) {
//             int j = i, k = i;
//             while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
//                 j--;
//                 k++;
//             }
//             if (k - j - 1 > end - start) {
//                 start = j + 1;
//                 end = k;
//             }

//             j = i;
//             k = i + 1;
//             while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
//                 j--;
//                 k++;
//             }

//             if (k - j - 1 > end - start) {
//                 start = j + 1;
//                 end = k;
//             }
//         }
//         return s.substring(start, end);


        // O(n^2) DP LCS
//         int dp[][] = new int[s.length() + 1][s.length() + 1];
//         String ts = new StringBuilder(s).reverse().toString();
//         int res = 0, end = 0;

//         for (int i = 0; i < s.length(); ++ i) {
//             for (int j = 0; j < ts.length(); ++ j) {
//                 if (s.charAt(i) == ts.charAt(j)) {
//                     dp[i + 1][j + 1] = dp[i][j] + 1;

//                     if (ts.charAt(j) == ts.charAt(j - dp[i + 1][j + 1] + 1)
//                         && dp[i + 1][j + 1] > res) {
//                         res = dp[i + 1][j + 1];
//                         end = i;
//                     }
//                 }
//             }
//         }
//         // System.out.println(res);
//         return s.substring(end - res + 1, end + 1);

        // O(n^2) DP
//         int dp[][] = new int[s.length()][s.length()];
//         int start = 0, end = 0;
//         for (int i = 0; i < s.length(); ++ i) {
//             dp[i][i] = 1;
//         }

//         for (int len = 1; len < s.length(); ++ len) {
//             for (int i = 0; i + len < s.length(); ++ i) {
//                 if (s.charAt(i) == s.charAt(i + len)) {
//                     if (len == 1) dp[i][i + len] = 1;
//                     else {
//                         dp[i][i + len] = dp[i + 1][i + len - 1];
//                     }

//                     if (dp[i][i + len] == 1) {
//                         start = i;
//                         end = i + len;
//                     }
//                 }
//             }
//         }
//         return s.substring(start, end + 1);


        // O(n) Manacher's algorithm https://www.felix021.com/blog/read.php?2040

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        String str = sb.toString();

        int p[] = new int[str.length()];
        p[0] = 1;
        int mx = 0, id = 0, res = 0, maxId = 0;
        for (int i = 1; i < str.length(); ++i) {
            if (mx >= i) {
                p[i] = Math.min(p[2 * id - i], mx - i);
            }
            while (i - p[i] >= 0 && i + p[i] < str.length() && str.charAt(i + p[i]) == str.charAt(i - p[i])) p[i]++;
            if (p[i] > mx) {
                mx = p[i];
                id = i;
            }
            if (p[i] > res) {
                res = p[i];
                maxId = i;
            }
        }
        str = str.substring(maxId - res + 1, maxId + res);
        sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != '#') sb.append(str.charAt(i));
        }
        return sb.toString();


    }
}
