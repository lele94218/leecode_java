package com.terryx.leecode.weeklycontest.contest66;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 1/6/18 9:31 PM.
 */
public class Solution760 {
    public int[] anagramMappings(int[] A, int[] B) {
        if (A == null || B == null) {
            return null;
        }
        int res[] = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; ++ i) {
            map.put(B[i], i);
        }
        for (int i = 0; i < A.length; ++ i) {
            res[i] = map.get(A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution760 m = new Solution760();
        System.out.println(Utils.debug(m.anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28})));
    }
}
