package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/23/17 2:37 PM.
 */
public class Solution93 {
    private void dfs(String s, int cur, List<String> ip, List<String> res) {
        if (cur == s.length() && ip.size() == 4) {
            res.add(ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3));
            return;
        }

        if (cur == s.length() || ip.size() > 4) {
            return;
        }

        int val = 0;
        if (s.charAt(cur) == '0') {
            ip.add(val + "");
            dfs(s, cur + 1, ip, res);
            ip.remove(ip.size() - 1);
            return;
        }

        for (int i = cur; i < s.length(); ++i) {
            val = val * 10 + s.charAt(i) - '0';
            if (val > 255) break;
            ip.add(val + "");
            dfs(s, i + 1, ip, res);
            ip.remove(ip.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<String>(0);
        List<String> res = new ArrayList<String>();
        dfs(s, 0, new ArrayList<String>(), res);
        return res;
    }
}
