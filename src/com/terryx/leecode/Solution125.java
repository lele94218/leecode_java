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

    public boolean isPalindrome0(String s) {
        if (s == null) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char c1 = Character.toLowerCase(s.charAt(i)), c2 = Character.toLowerCase(s.charAt(j));
            if (!Character.isLetterOrDigit(c1)) {
                i++;
            } else if (!Character.isLetterOrDigit(c2)) {
                j--;
            } else {
                if (c1 != c2) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
