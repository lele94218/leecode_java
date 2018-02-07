package com.terryx.leecode.weeklycontest.contest56;

import java.util.*;

/**
 * @author taoranxue on 2/6/18 11:30 PM.
 */
public class Solution443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        char pre = chars[0];
        int cnt = 1, index = 1;
        for (int i = 1; i < chars.length; ++i) {
            char c = chars[i];
            if (c == pre) {
                cnt++;
            } else {
                if (cnt > 1) {
                    String str = Integer.toString(cnt);
                    for (int j = 0; j < str.length(); ++j) {
                        chars[index++] = str.charAt(j);
                    }
                }
                chars[index++] = c;
                cnt = 1;
                pre = c;
            }


        }


        if (cnt > 1) {
            String str = Integer.toString(cnt);
            for (int j = 0; j < str.length(); ++j) {
                chars[index++] = str.charAt(j);
            }
        }
//
//        for (int i = 0; i < index; ++ i) {
//            System.out.print(chars[i]);
//        }
//        System.out.println();
        return index;
    }

    public static void main(String[] args) {
        Solution443 m = new Solution443();
//        System.out.println(m.compress(new char[]{'a'}));
        System.out.println(m.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
}
