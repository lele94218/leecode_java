package com.terryx.leecode.contest50;

import java.util.*;

/**
 * @author taoranxue on 9/16/17 9:33 PM.
 */
public class Solution680 {
    private boolean flag = true;
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
//        System.out.println(s);
        int i = 0, j = s.length() - 1;
        while (i <= j) {
//            System.out.println(s.charAt(i) + "==" + s.charAt(j));
            if (s.charAt(i) != s.charAt(j)) {
                if (flag) {
                    flag = false;
                    if (s.charAt(i + 1) == s.charAt(j) && s.charAt(i) == s.charAt(j - 1)) {
                        return validPalindrome(s.substring(i + 1, j + 1)) || validPalindrome(s.substring(i, j));
                    }
                    if (s.charAt(i + 1) == s.charAt(j)) {
                        i = i + 1;
                        continue;
                    }
                    if (s.charAt(i) == s.charAt(j - 1)) {
                        j = j - 1;
                        continue;
//                        return
                    }
                }
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}
