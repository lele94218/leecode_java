package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/21/18 4:16 PM.
 */
public class Solution245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int i = -1, j = -1, res = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        for (int k = 0; k < words.length; ++k) {
            String word = words[k];
            if (word.equals(word1)) {
                if (same) {
                    i = j;
                    j = k;
                } else {
                    i = k;
                }
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
