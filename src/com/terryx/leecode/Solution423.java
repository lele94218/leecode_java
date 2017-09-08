package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/8/17 11:05 AM.
 */
public class Solution423 {
    public String originalDigits(String s) {
        if (s == null || s.length() == 0) return s;
        int count[] = new int[10];
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i);
            if (c == 'z') count[0]++;
            if (c == 'o') count[1]++;
            if (c == 'w') count[2]++;
            if (c == 'r') count[3]++;
            if (c == 'u') count[4]++;
            if (c == 'v') count[5]++;
            if (c == 'x') count[6]++;
            if (c == 's') count[7]++;
            if (c == 'h') count[8]++;
            if (c == 'i') count[9]++;
        }
        count[1] -= count[2] + count[0] + count[4];
        count[3] -= count[4] + count[0];
        count[7] -= count[6];
        count[5] -= count[7];
        count[8] -= count[3];
        count[9] -= count[5] + count[6] + count[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            while (count[i]-- > 0) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
