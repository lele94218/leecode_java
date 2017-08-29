package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/30/17 4:19 AM.
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() == 0) return false;
        // O(m)
        // int i = 0, j = 0;
        // while (i < s.length() && j < t.length()) {
        //     if (s.charAt(i) == t.charAt(j)) {
        //         i ++;
        //         if (i == s.length()) return true;
        //     }
        //     j ++;
        // }
        // return false;

        // O(m + n * log(m))
        List<Integer> table[] = new List[256];
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            if (table[c] == null)
                table[c] = new ArrayList<>();
            table[c].add(i);
        }

        int cur = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            List<Integer> list = table[c];
            if (list == null) return false;
            int low = 0, high = list.size() - 1;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                int midVal = list.get(mid);
                if (midVal < cur) {
                    low = mid + 1;
                } else if (midVal >= cur) {
                    high = mid - 1;
                }
            }

            if (low == list.size()) return false;
            cur = list.get(low) + 1;
        }
        return true;
    }
}
