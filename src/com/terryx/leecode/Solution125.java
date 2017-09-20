package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/20/17 4:21 PM.
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
