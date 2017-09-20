package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/19/17 4:14 PM.
 */
public class Solution282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        dfs(num, 0, target, 0, 0, res, "");
        return res;
    }

    private void dfs(String num, int cur, int target, long val, long last, List<String> res, String str) {
        if (cur == num.length()) {
            // System.out.println(str + "=" + val + " " + target);
            if (val == target) {
                res.add(str);
            }
            return;
        }
        long a = 0;
        for (int i = cur; i < num.length(); ++i) {
            if (num.charAt(cur) == '0' && i - cur > 0) break;
            a = a * 10 + num.charAt(i) - '0';
            if (cur == 0) {
                dfs(num, i + 1, target, a, a, res, "" + a);
            } else {
                dfs(num, i + 1, target, val + a, a, res, str + "+" + a);
                dfs(num, i + 1, target, val - a, -a, res, str + "-" + a);
                dfs(num, i + 1, target, val - last + last * a, last * a, res, str + "*" + a);
            }
        }
    }
}
