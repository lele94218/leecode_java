package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/1/17 10:16 AM.
 */
public class Solution13 {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int map[] = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        int sum = map[s.charAt(s.length() - 1) - 'A'];
        for (int i = s.length() - 2; i >= 0; --i) {
            int c1 = s.charAt(i) - 'A', c2 = s.charAt(i + 1) - 'A';
            // System.out.println((int) (s.charAt(i) - 'A') + " " + (int) (s.charAt(i + 1) - 'A'));
            if (map[c1] < map[c2]) {
                sum -= map[c1];
            } else {
                sum += map[c1];
            }
        }
        return sum;
    }
}
