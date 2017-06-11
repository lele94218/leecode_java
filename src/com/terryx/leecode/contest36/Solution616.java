package com.terryx.leecode.contest36;

import java.util.HashMap;

/**
 * @author taoranxue on 6/10/17 11:25 PM.
 */
public class Solution616 {
    public String addBoldTag(String s, String[] dict) {
        return null;
    }
    public String addBoldTag1(String s, String[] dict) {
        StringBuffer sb = new StringBuffer();
        int[] dp = new int[s.length()];
        for (int i = 0; i < dict.length; i++) {
            int index = s.indexOf(dict[i]);
            while (index >= 0) {
                dp[index] = Math.max(dp[index], dict[i].length());
                index = s.indexOf(dict[i], index + 1);
            }
        }
        int start = 0;
        while (start < s.length()) {
            if (dp[start] == 0) {
                sb.append(s.charAt(start));
                start++;
            } else {
                int formerStart = start;
                int end = start + dp[start];
                while (start != end) {
                    int cur = start;
                    while (cur < s.length() && dp[cur] != 0) {
                        cur = dp[cur] + cur;
                    }
                    end = Math.max(end, cur);
                    start++;
                }
                sb.append("<b>" + s.substring(formerStart, start) + "</b>");
            }
        }
        return sb.toString();
    }
}

