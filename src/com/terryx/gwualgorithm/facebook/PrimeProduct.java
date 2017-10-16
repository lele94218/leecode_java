package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/16/17 4:11 PM.
 */
public class PrimeProduct {
    /**
     * product of prime
     * A = [2,3,5,7] primes
     * B = [1,2,1,3] numbers of primes
     */
    public List<Integer> product(int primes[], int nums[]) {
        List<Integer> ans = new ArrayList<>();
        dfs(0, primes, nums, 1, ans);
        return ans;
    }

    private void dfs(int cur, int primes[], int nums[], int res, List<Integer> ans) {
        if (cur == primes.length) {
            ans.add(res);
            return;
        }
        for (int i = 0; i <= nums[cur]; ++i) {
            if (i > 0) {
                res *= primes[cur];
            }
            dfs(cur + 1, primes, nums, res, ans);
        }
    }

    public static void main(String[] args) {
        PrimeProduct i = new PrimeProduct();
        List<Integer> l = i.product(new int[]{2, 3, 5, 7}, new int[]{1, 1, 1, 1});
        Collections.sort(l);
        System.out.println(l + ": " + l.size());
    }
}
