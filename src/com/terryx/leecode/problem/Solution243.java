package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/21/18 4:00 PM.
 */
public class Solution243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int i = -1, j = -1, res = Integer.MAX_VALUE;
        for (int k = 0; k < words.length; ++ k) {
            String word = words[k];
            if (word.equals(word1)) {
                i = k;
            } else if (word.equals(word2)) {
                j = k;
            }

            if (i > -1 && j > -1) {
                res = Math.min(res, Math.abs(i - j));
            }
        }
        return res;
    }
}
