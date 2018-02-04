package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/5/17 6:56 PM.
 */
public class Solution556 {
    public int nextGreaterElement(int n) {
        String str = n + "";
        char[] s = str.toCharArray();
        int i = s.length - 1;
        for (; i > 0; --i) {
            if (s[i] > s[i - 1]) {
                int index = -1, t = Integer.MAX_VALUE;
                for (int j = i; j < s.length; ++j)
                    if (s[j] > s[i - 1]) {
                        if (s[j] < t) {
                            t = s[j];
                            index = j;
                        }
                    }
                if (index >= i) {
                    char tmp = s[i - 1];
                    s[i - 1] = s[index];
                    s[index] = tmp;
                    Arrays.sort(s, i, s.length);
                    break;
                }
            }
        }


        long res = Long.parseLong(new String(s));
        // System.out.println(res);
        if (res > Integer.MAX_VALUE || n == (int) res) return -1;
        return (int) res;
    }
}
