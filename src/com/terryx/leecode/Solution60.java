package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/7/17 1:34 PM.
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        int frac[] = new int[10];
        List<Integer> nums = new LinkedList<>();
        frac[0] = 1;
        for (int i = 1; i <= 9; ++i) {
            frac[i] = i * frac[i - 1];
        }
        for (int i = 1; i <= n; ++i) nums.add(i);
        k -= 1;
        String res = "";
        while (nums.size() > 0) {
            int idx = k / frac[nums.size() - 1];
            res += nums.get(idx);
            k -= idx * frac[nums.size() - 1];
            nums.remove(idx);
        }
        return res;
    }
}
