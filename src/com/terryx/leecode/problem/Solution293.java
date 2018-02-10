package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/9/18 6:57 PM.
 */
public class Solution293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length - 1; ++i) {
            if (str[i] == '+' && str[i + 1] == '+') {
                str[i] = '-';
                str[i + 1] = '-';
                res.add(new String(str));
                str[i] = '+';
                str[i + 1] = '+';
            }
        }
        return res;
    }
}
