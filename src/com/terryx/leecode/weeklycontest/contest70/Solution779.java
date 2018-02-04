package com.terryx.leecode.weeklycontest.contest70;

import java.util.*;

/**
 * @author taoranxue on 2/3/18 9:37 PM.
 */
public class Solution779 {
    public int kthGrammar(int N, int K) {
//        System.out.println(N + " " + K);
        if (N == 1) {
            return 0;
        }
        int len = 1 << (N - 1);
        if (K > (len >> 1)) {
            return flip(kthGrammar(N - 1, K - (len >> 1)));
        } else {
            return kthGrammar(N - 1, K);
        }
    }

    private int flip(int n) {
        if (n == 1) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution779 m = new Solution779();
        System.out.println(m.kthGrammar(1, 1));
        System.out.println(m.kthGrammar(2, 1));
        System.out.println(m.kthGrammar(2, 2));
        System.out.println(m.kthGrammar(4, 5));
    }
}
