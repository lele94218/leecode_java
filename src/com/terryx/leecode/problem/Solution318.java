package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/6/17 12:40 PM.
 */
public class Solution318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int mark[] = new int[words.length];
        for (int i = 0; i < words.length; ++ i) {
            String word = words[i];
            for (int j = 0; j < word.length(); ++ j) {
                int c = word.charAt(j);
                mark[i] |= 1 << c - 'a';
            }
        }
        int res = 0;
        for (int i = 0; i < mark.length; ++ i) {
            for (int j = i + 1; j < mark.length; ++ j) {
                if ((mark[i] & mark[j]) == 0) {
                    // System.out.println(i + " " + j);
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
