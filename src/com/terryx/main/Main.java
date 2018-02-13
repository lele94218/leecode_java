package com.terryx.main;

import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    public int solution(String S) {
        // write your code in Java SE 8
        if (S == null || S.length() == 0) {
            return 0;
        }
        int res = 1, cur = 1;
        int dp[] = new int[26];
        dp[S.charAt(0) - 'a'] = 1;
        for (int i = 1; i < S.length(); ++i) {
            char c = S.charAt(i);
            int to = c - 'a', tmp = 0;
            for (int j = 0; j <= to; ++j) {
                tmp = Math.max(tmp, dp[j]);
            }
            if (tmp > 0) {
                dp[to] = Math.max(dp[to], tmp + 1);
            } else {
                dp[to] = 1;
            }
            res = Math.max(dp[to], res);
        }
        System.out.println(Utils.debug(dp));
        System.out.println(S.length());
        return S.length() - res;
    }

    class A extends B implements Comparable<A> {

        @Override
        public int compareTo(A o) {
            return 0;
        }
    }

    class B {

    }

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        Random r = new Random();

    }

}
