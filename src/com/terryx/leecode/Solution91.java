package com.terryx.leecode;

/**
 * @author taoranxue on 10/18/16 1:20 AM.
 */
public class Solution91 {
    public int numDecodings(String s) {
        if (s.equals("")) return 0;
        int n = s.length();
        int[] a = new int[n + 1];
        a[n] = 1;
        a[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; --i) {
            if (s.charAt(i) == '0') continue;
            int c = Integer.parseInt(s.substring(i, i + 2));
            if (c > 0 && c <= 26) a[i] = a[i + 1] + a[i + 2];
            else a[i] = a[i + 1];
        }
        return a[0];
    }
}
