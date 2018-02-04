package com.terryx.leecode.problem;

/**
 * @author taoranxue on 10/30/16 4:44 PM.
 */
public class Solution246 {
    public boolean isStrobogrammatic(String num) {
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if ((num.charAt(i) == '8' && num.charAt(j) == '8')
                    || (num.charAt(i) == '1' && num.charAt(j) == '1')
                    || (num.charAt(i) == '0' && num.charAt(j) == '0')) {
                continue;
            } else if ((num.charAt(i) == '6' && num.charAt(j) == '9')
                    || (num.charAt(i) == '9' && num.charAt(j) == '6')) {
                continue;
            }
            return false;
        }
        return true;
    }
}
