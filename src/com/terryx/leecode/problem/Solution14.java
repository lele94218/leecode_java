package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/1/17 10:26 AM.
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int res = 0, index = 0, bound = Integer.MAX_VALUE;

        for (String word : strs) {
            bound = Math.min(bound, word.length());
        }

        while (index < bound) {
            char c = strs[0].charAt(index);
            for (String word : strs) {
                if (word.charAt(index) != c) {
                    return word.substring(0, res);
                }
            }
            res++;
            index++;
        }
        return strs[0].substring(0, res);
    }
}
