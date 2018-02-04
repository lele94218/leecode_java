package com.terryx.leecode.problem;

/**
 * @author taoranxue on 8/12/17 8:41 PM.
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        int map[] = new int[256];
        for (int i = 0; i < s1.length(); ++ i) {
            map[s1.charAt(i)]++;
        }
        int begin = 0, end = 0, cnt = s1.length();
        for (; end < s2.length(); end ++) {
            if (map[s2.charAt(end)]-- > 0) {
                cnt--;
            }
            while (cnt == 0) {
                if (end - begin + 1 == s1.length()) {
                    return true;
                }
                if (map[s2.charAt(begin++)]++ == 0) {
                    cnt++;
                }
            }
        }
        return false;
    }
}
