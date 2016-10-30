package com.terryx.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 10/30/16 7:08 PM.
 */
public class Solution204 {
    public int countPrimes(int n) {
        boolean isPrime[] = new boolean[n + 1];
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i < n; ++i) {
            if (!isPrime[i]) prime.add(i);
            for (int j = 0; j < prime.size() && prime.get(j) * i < n; ++j) {
                isPrime[prime.get(j) * i] = true;
                if (i % prime.get(j) == 0) break;
            }
        }
        int res = 0;
        for (int i = 2; i < n; ++i) {
            if (!isPrime[i]) res++;
        }
        return res;
    }

    public int countPrimesQuick(int n) {
        boolean isPrime[] = new boolean[n + 1];
        for (int i = 2; i * i < n; ++i) {
            if (!isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; ++i) {
            if (!isPrime[i]) res++;
        }
        return res;
    }
}
