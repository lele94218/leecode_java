package com.terryx.leecode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author taoranxue on 8/12/17 10:12 AM.
 */
public class Solution524 {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0 || d == null || d.size() == 0) return "";
        Collections.sort(d, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length())
                    return b.length() - a.length();
                return a.compareTo(b);
            }
        });

        for (String word : d) {
            int i = 0, j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }

            if (j == word.length()) {
                return word;
            }
        }
        return "";
    }
}
