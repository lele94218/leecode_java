package com.terryx.leecode.weeklycontest.contest73;

import java.util.*;

/**
 * @author taoranxue on 2/24/18 9:55 PM.
 */
public class Solution791 {
    public String customSortString(String S, String T) {
        char[] map = S.toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < T.length(); ++i) {
            char c = T.charAt(i);
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; ++i) {
            int c = map[i] - 'a';
            while (cnt[c] > 0) {
                sb.append((char) (c + 'a'));
                cnt[c]--;
            }
        }

        for (int i = 0; i < 26; ++ i) {
            while (cnt[i] > 0) {
                sb.append((char)(i + 'a'));
                cnt[i]--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution791 m = new Solution791();
        System.out.println(m.customSortString("dcba", "zeabzecdddd"));
    }
}
