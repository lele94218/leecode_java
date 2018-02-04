package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/23/17 3:28 PM.
 */
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int ix = 0;
        while (ix < v1.length || ix < v2.length) {
            String s1 = "0", s2 = "0";
            if (ix < v1.length) s1 = v1[ix];
            if (ix < v2.length) s2 = v2[ix];
            int res = compareNumber(s1, s2);
            if (res != 0) {
                return res;
            }
            ++ ix;
        }
        return 0;
    }

    private int compareNumber(String s1, String s2) {
        if (s1 == "" && s2 == "") return 0;
        if (s1 == "") return -1;
        if (s2 == "") return 1;

        int cur1 = 0, cur2 = 0;
        while (cur1 < s1.length() && s1.charAt(cur1) == '0') {
            cur1 ++;
        }
        while (cur2 < s2.length() && s2.charAt(cur2) == '0') {
            cur2 ++;
        }

        s1 = s1.substring(cur1, s1.length());
        s2 = s2.substring(cur2, s2.length());

        int res = s1.length() - s2.length();

        if (res != 0) {
            return res > 0 ? 1 : -1;
        }

        res = s1.compareTo(s2);

        if (res != 0) {
            return res > 0 ? 1 : -1;
        }
        return 0;

    }
}
