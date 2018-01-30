package com.terryx.leecode.weeklycontest.contest67;

import java.util.*;

/**
 * @author taoranxue on 1/13/18 9:34 PM.
 */
public class Solution762 {
    public int countPrimeSetBits(int L, int R) {
        int prime[] = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 612, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < prime.length; ++ i) {
            set.add(prime[i]);
        }
        int res = 0;
        for (int i = L; i <= R; ++i) {
            int n = Integer.bitCount(i);
            if (set.contains(n)) {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution762 m = new Solution762();
        System.out.println(m.countPrimeSetBits(10, 15));
    }
}
