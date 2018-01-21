package com.terryx.leecode.contest68;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 9:36 PM.
 */
public class Solution767 {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        int cnt[] = new int[26], next[] = new int[26];

        for (int i = 0; i < S.length(); ++ i) {
            char c = S.charAt(i);
            cnt[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); ++ i) {
            int index = -1, max = 0;
            for (int t = 0; t < 26; ++ t) {
                if (cnt[t] > max && i >= next[t]) {
                    max = cnt[t];
                    index = t;
                }
            }

            if (index == -1) {
                return "";
            }
            sb.append((char)('a' + index));
            cnt[index]--;
            next[index] = i + 2;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution767 m = new Solution767();
        System.out.println(m.reorganizeString("aaab"));
        System.out.println(m.reorganizeString("aab"));
        System.out.println(m.reorganizeString("aabb"));
        System.out.println(m.reorganizeString("abab"));
        System.out.println(m.reorganizeString(""));
        System.out.println(m.reorganizeString("zxcvccc"));
    }
}
