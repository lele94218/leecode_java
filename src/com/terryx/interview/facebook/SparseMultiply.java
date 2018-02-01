package com.terryx.interview.facebook;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 10/15/17 8:23 PM.
 */
public class SparseMultiply {
    /**
     * Using hash map
     */
    public int vectorMultiply0(int[] A, int[] B) {
        Map<Integer, Integer> mapA = new HashMap<>(), mapB = new HashMap<>();
        int m = A.length, n = B.length;
        for (int i = 0; i < m; ++i)
            if (A[i] != 0) {
                mapA.put(i, A[i]);
            }
        for (int i = 0; i < n; ++i)
            if (B[i] != 0) {
                mapB.put(i, B[i]);
            }
        int res = 0;
        for (Integer i : mapA.keySet()) {
            if (mapB.containsKey(i)) {
                res += mapA.get(i) * mapB.get(i);
            }
        }
        return res;
    }

    /**
     * Using list
     */
    public int vectorMultiply1(int[] A, int[] B) {
        List<Integer> listA = new ArrayList<>(), listB = new ArrayList<>();
        int m = A.length;
        for (int i = 0; i < m; ++i)
            if (A[i] != 0) {
                listA.add(i);
                listA.add(A[i]);
            }

        for (int i = 0; i < m; ++i)
            if (B[i] != 0) {
                listB.add(i);
                listB.add(B[i]);
            }

        int i = 0, j = 0, res = 0;
        while (i < listA.size() && j < listB.size()) {
            if (listA.get(i).equals(listB.get(j))) {
                res += listA.get(i + 1) * listB.get(j + 1);
                i += 2;
                j += 2;
            } else if (listA.get(i) < listB.get(j)) {
                i += 2;
            } else {
                j += 2;
            }
        }
        return res;
    }

    /**
     * Using hash map
     */
    public int[][] matrixMultiply0(int[][] A, int[][] B) {
        if (A == null || B == null) return null;
        int m = A.length, n = B.length, l = B[0].length;
        Map<Integer, Integer> mapA[] = new Map[m], mapB[] = new Map[n];
        for (int i = 0; i < m; ++i) {
            mapA[i] = new HashMap<Integer, Integer>();
            for (int k = 0; k < n; ++k)
                if (A[i][k] != 0) {
                    mapA[i].put(k, A[i][k]);
                }
        }

        for (int k = 0; k < n; ++k) {
            mapB[k] = new HashMap<Integer, Integer>();
            for (int j = 0; j < l; ++j)
                if (B[k][j] != 0) {
                    mapB[k].put(j, B[k][j]);
                }
        }
        int res[][] = new int[m][l];
        for (int i = 0; i < m; ++i) {
            for (Integer k : mapA[i].keySet()) {
                for (Integer j : mapB[k].keySet()) {
                    res[i][j] += mapA[i].get(k) * mapB[k].get(j);
                }
            }
        }
        return res;
    }

    /**
     * Using list
     */
    public int[][] matrixMultiply1(int[][] A, int[][] B) {
        if (A == null || B == null) return null;
        int m = A.length, n = B.length, l = B[0].length;
        List<Integer> listA[] = new List[m], listB[] = new List[n];
        for (int i = 0; i < m; ++i) {
            listA[i] = new ArrayList<>();
            for (int k = 0; k < n; ++k)
                if (A[i][k] != 0) {
                    listA[i].add(k);
                    listA[i].add(A[i][k]);
                }
        }
        for (int k = 0; k < n; ++k) {
            listB[k] = new ArrayList<>();
            for (int j = 0; j < l; ++j)
                if (B[k][j] != 0) {
                    listB[k].add(j);
                    listB[k].add(B[k][j]);
                }
        }
        int res[][] = new int[m][l];
        for (int i = 0; i < m; ++i) {
            for (int idxA = 0; idxA < listA[i].size(); idxA += 2) {
                int k = listA[i].get(idxA);
                for (int idxB = 0; idxB < listB[k].size(); idxB += 2) {
                    int j = listB[k].get(idxB);
                    res[i][j] += listA[i].get(idxA + 1) * listB[k].get(idxB + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SparseMultiply i = new SparseMultiply();
        System.out.println(Utils.debug(
                i.vectorMultiply1(new int[]{1, 2, 3, 99, 0, 6}, new int[]{3, 11, 0, 10, 0, 0}
                )));

    }
}
