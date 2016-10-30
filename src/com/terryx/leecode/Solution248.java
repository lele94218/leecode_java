package com.terryx.leecode;

/**
 * @author taoranxue on 10/30/16 6:38 PM.
 */
public class Solution248 {
    private static final char addPairs[][] = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
    private int cnt = 0;

    public int strobogrammaticInRange(String low, String high) {
        for (int len = low.length(); len <= high.length(); ++ len) {
            dfs(low, high, 0, len - 1, new char[len]);
        }
        return cnt;
    }

    private void dfs(String low, String high, int left, int right, char[] c) {
        if (left > right) {
            String str = String.valueOf(c);
            if ((str.length() == low.length() && str.compareTo(low) < 0)
                    || (str.length() == high.length() && str.compareTo(high) > 0))
                return;
            cnt++;
            return;
        }
        for (char[] pair : addPairs) {
            c[left] = pair[0];
            c[right] = pair[1];
            if (c.length > 1 && c[0] == '0') continue;
            if (left == right && pair[0] != pair[1]) continue;
            dfs(low, high, left + 1, right - 1, c);
        }
    }
}
