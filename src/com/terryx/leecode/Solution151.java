package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/23/17 2:48 PM.
 */
public class Solution151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String[] words = s.split("\\s+");
        if (words.length == 0) return "";
        int i = words.length - 1, end = 0;
        if (words[0].equals("")) end++;
        StringBuilder sb = new StringBuilder();
        for (; i > end; --i) {
            sb.append(words[i] + " ");
        }
        sb.append(words[i]);
        return sb.toString();
    }
}
