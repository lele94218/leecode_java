package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/31/18 5:19 PM.
 */
public class Solution345 {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int i = 0, j = s.length() - 1;
        char a[] = s.toCharArray();
        while (i < j) {
            char c1 = a[i], c2 = a[j];
            if (isVowel(c1) && isVowel(c2)) {
                swap(a, i++, j--);
            } else if (!isVowel(c1)) {
                i++;
            } else {
                j--;
            }
        }
        return new String(a);
    }

    private void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
