package com.terryx.leecode.weeklycontest.contest73;

import java.util.*;

/**
 * @author taoranxue on 2/24/18 9:30 PM.
 */
public class Solution788 {
    public int rotatedDigits(int N) {
        int cnt = 0;
        int[] dict = new int[10];
        Arrays.fill(dict, -1);
        dict[0] = 0;
        dict[1] = 1;
        dict[8] = 8;
        dict[2] = 5;
        dict[5] = 2;
        dict[6] = 9;
        dict[9] = 6;
        for (int num = 1; num <= N; ++num) {
            String str = Integer.toString(num);
            int res = 0;
            boolean flag = true;
            for (int i = 0; i < str.length(); ++ i) {
                int n = str.charAt(i) - '0';
                if (dict[n] != -1) {
                    res = res * 10 + dict[n];
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag && res != num) {
//                System.out.println(num + " " + res);
                cnt++;
            }

        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution788 m = new Solution788();
        System.out.println(m.rotatedDigits(10));
    }
}
