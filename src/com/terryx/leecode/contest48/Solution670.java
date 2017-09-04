package com.terryx.leecode.contest48;

import java.util.*;

/**
 * @author taoranxue on 9/2/17 10:14 PM.
 */
public class Solution670 {
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] s = str.toCharArray();
        int res = num;
        for (int i = 0; i < str.length(); ++ i) {
            for (int j = i + 1; j < str.length(); ++ j) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
                int newValue = Integer.parseInt(new String(s));
                res = Math.max(newValue, res);
                tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }

        }
        return res;
    }
}
