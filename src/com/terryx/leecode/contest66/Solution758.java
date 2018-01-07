package com.terryx.leecode.contest66;

import java.util.*;

/**
 * @author taoranxue on 1/6/18 9:40 PM.
 */
public class Solution758 {
    public String boldWords(String[] words, String S) {
        if (words == null || S == null) {
            return S;
        }
        int mark[] = new int[S.length()];
        for (String word : words) {
            int index = 0;
            while (index < S.length() && (index = S.indexOf(word, index)) != -1) {
                for (int i = 0; i < word.length(); ++i) {
                    mark[index + i] = 1;
                }
                index++;
            }
        }
        String res = "";
        boolean flag = false;
        for (int i = 0; i < mark.length; ++i) {
            if (mark[i] > 0 && !flag) {
                res += "<b>";
                flag = true;
            } else if (mark[i] == 0 && flag) {
                res += "</b>";
                flag = false;
            }
            res += S.charAt(i);
        }

        if (flag) {
            res += "</b>";
        }

        return res;
    }

    public static void main(String[] args) {
        Solution758 m = new Solution758();
        System.out.println(m.boldWords(new String[]{"aazb", "bzc"}, "aabcd"));
    }
}
