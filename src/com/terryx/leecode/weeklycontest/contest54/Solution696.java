package com.terryx.leecode.weeklycontest.contest54;

import java.util.*;

/**
 * @author taoranxue on 2/9/18 7:37 PM.
 */
public class Solution696 {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        char pre = s.charAt(0);
        int cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            while (i < s.length() && s.charAt(i) == pre) {
                cnt++;
                i++;
            }
            if (i < s.length()) {
                list.add(cnt);
                cnt = 1;
                pre = s.charAt(i);
            }
        }
        list.add(cnt);
        int res = 0;
        for (int i = 1; i < list.size(); ++i) {
            int min = Math.min(list.get(i - 1), list.get(i));
            res += min;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution696 m = new Solution696();
        System.out.println(m.countBinarySubstrings("10101"));
    }
}
