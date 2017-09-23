package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/20/17 7:46 PM.
 */
public class Solution38 {
    public String countAndSay(int n) {
        String str = "1";
        while (--n > 0) {
            // System.out.println(str);
            StringBuilder sb = new StringBuilder();
            char c = str.charAt(0);
            int cnt = 1;
            for (int i = 1; i < str.length(); ++i) {
                char nc = str.charAt(i);
                if (c == nc) {
                    ++cnt;
                } else {
                    sb.append(cnt).append(c);
                    c = nc;
                    cnt = 1;
                }
            }
            if (cnt > 0) {
                sb.append(cnt).append(c);
            }
            str = sb.toString();
        }
        return str;
    }
}
