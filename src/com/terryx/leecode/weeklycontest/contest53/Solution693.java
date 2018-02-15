package com.terryx.leecode.weeklycontest.contest53;

import java.util.*;

/**
 * @author taoranxue on 2/15/18 2:25 PM.
 */
public class Solution693 {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        for (int i = 1; i < s.length(); ++ i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
