package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/4/17 12:28 PM.
 */
public class Solution522 {
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) return -1;
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });
        for (int i = 0; i < strs.length; ++i) {
            int cnt = 0;
            for (int j = 0; j < strs.length; ++j) {
                if (i != j && !isSubsequence(strs[i], strs[j])) {
                    cnt++;
                }
            }

            if (cnt == strs.length - 1) return strs[i].length();
        }
        return -1;
    }

    private boolean isSubsequence(String a, String b) {
        int index = 0;
        for (int i = 0; i < b.length(); ++i) {
            if (index < a.length() && a.charAt(index) == b.charAt(i)) {
                index++;
            }
        }

        return (index == a.length());
    }
}
