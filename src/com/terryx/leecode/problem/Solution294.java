package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/9/18 7:07 PM.
 */
public class Solution294 {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return dfs(s.toCharArray());
    }

    private boolean dfs(char[] str) {
        for (int i = 0; i < str.length - 1; ++i) {
            if (str[i] == '+' && str[i + 1] == '+') {
                str[i] = str[i + 1] = '-';
                boolean res = dfs(str);
                str[i] = str[i + 1] = '+';
                if (!res) {
                    return true;
                }
            }
        }
        return false;
    }
}
