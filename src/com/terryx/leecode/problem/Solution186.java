package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 10/23/17 1:43 AM.
 */
public class Solution186 {
    public void reverseWords(char[] str) {
        if (str == null) return;
        for (int i = 0; i < str.length; ++i) {
            if (str[i] != ' ') {
                int start = i;
                while (i + 1 < str.length && str[i + 1] != ' ') {
                    ++i;
                }
                int end = i;
                while (start < end) {
                    swap(str, start++, end--);
                }
            }
        }
        int start = 0, end = str.length - 1;
        while (start < end) {
            swap(str, start++, end--);
        }
    }

    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
