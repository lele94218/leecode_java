package com.terryx.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author taoranxue on 10/30/16 4:58 PM.
 */
public class Solution247 {
    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }

    private List<String> dfs(int n, int m) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> ret = dfs(n - 2, m);
        List<String> res = new ArrayList<>();

        for (String str : ret) {
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
            if (n < m) {
                res.add("0" + str + "0");
            }
        }
        return res;
    }
}
