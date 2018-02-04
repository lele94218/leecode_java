package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 10/18/17 1:15 PM.
 */
public class Solution358 {
    public String rearrangeString(String s, int k) {
        if (s == null) return "";
        int cnt[] = new int[26], nxt[] = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            int idx = -1, max = Integer.MIN_VALUE;
            for (int j = 0; j < cnt.length; ++j) {
                if (cnt[j] > 0 && cnt[j] > max && nxt[j] <= i) {
                    max = cnt[j];
                    idx = j;
                }
            }
            if (idx == -1) {
                return "";
            }
            sb.append((char) ('a' + idx));
            cnt[idx]--;
            nxt[idx] = i + k;
        }
        return sb.toString();
    }
}
