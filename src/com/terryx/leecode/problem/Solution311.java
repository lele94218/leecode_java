package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/14/17 4:38 PM.
 */
public class Solution311 {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null) return null;
        List<Integer> listA[] = new List[A.length];
        for (int i = 0; i < A.length; ++i) {
            listA[i] = new ArrayList<>();
            for (int j = 0; j < A[i].length; ++j)
                if (A[i][j] != 0) {
                    listA[i].add(j);
                    listA[i].add(A[i][j]);
                }
        }

        int res[][] = new int[A.length][B[0].length];
        for (int i = 0; i < listA.length; ++i) {
            for (int k = 0; k < listA[i].size(); k += 2) {
                int idx = listA[i].get(k), val = listA[i].get(k + 1);
                for (int j = 0; j < B[0].length; ++j) {
                    res[i][j] += B[idx][j] * val;
                }
            }
        }
        return res;
    }
}
