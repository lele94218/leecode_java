package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/19/17 4:14 PM.
 */
public class Solution282 {
    public List<String> addOperators1(String num, int target) {
        if (num == null) return new ArrayList<>(0);
        List<String> ans = new ArrayList<>();
        helper(num, 0, 0, 0, (long)target, "", ans);
        return ans;
    }

    private void helper(String num, int cur, long res, long last, long target, String path, List<String> ans) {
        if (cur == num.length()) {
            if (res == target) {
                ans.add(path);
            }
            return;
        }
        if (cur == 0) {
            long t = 0;
            for (int i = cur; i < num.length(); ++ i) {
                if (i == cur + 1 && num.charAt(cur) == '0') break;
                t = t * 10 + num.charAt(i) - '0';
                helper(num, i + 1, t, t, target, path + t, ans);
            }
        } else {
            long t = 0;
            for (int i = cur; i < num.length(); ++ i) {
                if (i == cur + 1 && num.charAt(cur) == '0') break;
                t = t * 10 + num.charAt(i) - '0';
                helper(num, i + 1, res + t, t, target, path + "+" + t, ans);
                helper(num, i + 1, res - t, -t, target, path + "-" + t, ans);
                helper(num, i + 1, (res - last) + (last * t), last * t, target, path + "*" + t, ans);
            }
        }
    }

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
