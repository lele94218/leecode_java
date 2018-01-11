package com.terryx.leecode.contest66;

import java.util.*;

/**
 * @author taoranxue on 1/10/18 10:34 PM.
 */
public class Solution761 {
    public String makeLargestSpecial(String S) {
        if (S == null) {
            return S;
        }
        int count = 0, i = 0;
        List<String> res = new ArrayList<>();
        for (int j = 0; j < S.length(); ++ j) {
            if (S.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res.add("1" + makeLargestSpecial(S.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }
        Collections.sort(res, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String str : res) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution761 m = new Solution761();
        System.out.println(m.makeLargestSpecial("11011000"));
    }
}
