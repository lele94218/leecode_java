package com.terryx.leecode.contest36;

import java.util.HashMap;

/**
 * @author taoranxue on 6/10/17 11:25 PM.
 */
public class Solution616 {
    public String addBoldTag(String s, String[] dict) {
        int dp[] = new int[s.length()];
        for (int i = 0; i < dict.length; ++i) {
            int index = s.indexOf(dict[i]);
            while (index >= 0) {
                dp[index] = dict[i].length();
                index = s.indexOf(dict[i], index + 1);
            }
        }
        StringBuilder res = new StringBuilder();
        int start = 0;
        while (start < s.length()) {
            if (dp[start] == 0) {
                res.append(s.charAt(start));
                start++;
            } else {
                int end = start + dp[start];
                int begin = start;
                while (start < end) {
                    int cur = start;
                    while (cur < s.length() && dp[cur] > 0) {
                        cur = cur + dp[cur];
                    }
                    end = Math.max(end, cur);
                    start++;
                }
                res.append("<b>").append(s.substring(begin, start)).append("</b>");
            }
        }

        return res.toString();
    }
}

