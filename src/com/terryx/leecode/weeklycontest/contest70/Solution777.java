package com.terryx.leecode.weeklycontest.contest70;

import java.util.*;

/**
 * @author taoranxue on 2/3/18 10:23 PM.
 */
public class Solution777 {
    public boolean canTransform(String start, String end) {
        if (start == null || end == null) {
            return true;
        }

        if (start.length() != end.length()) {
            return false;
        }

        int i = 0, j = 0;
        while (i < start.length() || j < end.length()) {
            if (i < start.length() && start.charAt(i) == 'X') {
                ++i;
            } else if (j < end.length() && end.charAt(j) == 'X') {
                ++j;
            } else if (i >= start.length() || j >= end.length() || start.charAt(i) != end.charAt(j)) {
                return false;
            } else if (start.charAt(i) == end.charAt(j)) {
                if (start.charAt(i) == 'L') {
                    if (i < j) {
                        return false;
                    }
                } else if (start.charAt(i) == 'R') {
                    if (i > j) {
                        return false;
                    }
                }
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution777 m = new Solution777();
        System.out.println(m.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(m.canTransform("X", "XXX"));
        System.out.println(m.canTransform("XRX", "XXR"));
        System.out.println(m.canTransform("X", "L"));
        System.out.println(m.canTransform("XXRXXLXXXX", "XXXXRXXLXX"));
    }
}
