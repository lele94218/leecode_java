package com.terryx.interview.facebook;

/**
 * @author taoranxue on 10/16/17 7:56 PM.
 */
public class RomanNumber {
    public String intToRoman(int num) {
        //note order. e.g. 1,4,5,9 -> 10,40,50,90 -> 100,400,500,900
        int val[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String sym[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length; ) {
            if (num == 0) break;
            if (num >= val[i]) {
                num -= val[i];
                sb.append(sym[i]);
            } else {
                ++i;
            }
        }
        return sb.toString();
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int map[] = new int[256];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        int sum = map[s.charAt(s.length() - 1)];
        for (int i = s.length() - 2; i >= 0; --i) {
            int left = map[s.charAt(i)], right = map[s.charAt(i + 1)];
            if (left >= right) {
                sum += left;
            } else {
                sum -= left;
            }
        }
        return sum;
    }
}
