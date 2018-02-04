package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/23/18 6:53 PM.
 */
public class Solution443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        char c = chars[0];
        int cnt = 0, index = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == c) {
                cnt++;
            } else {
                chars[index++] = c;
                if (cnt > 1) {
                    String str = Integer.toString(cnt);
                    for (int j = 0; j < str.length(); ++j) {
                        chars[index++] = str.charAt(j);
                    }
                }
                c = chars[i];
                cnt = 1;
            }
        }
        chars[index++] = c;
        if (cnt > 1) {
            String str = Integer.toString(cnt);
            for (int j = 0; j < str.length(); ++j) {
                chars[index++] = str.charAt(j);
            }
        }
        return index;
    }
}
