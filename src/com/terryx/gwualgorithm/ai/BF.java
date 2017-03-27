package com.terryx.gwualgorithm.ai;

/**
 * @author taoranxue on 3/27/17 4:41 PM.
 */
public class BF {
    private int m, n;
    private int[][] map = new int[][]{
            {0, 1, 7, 9, 7, 3, 3, 0, 9, 1, 6, 7, 9, 1, 4, 9, 4, 6, 8, 1},
            {0, 0, 7, 2, 4, 0, 5, 2, 7, 8, 6, 1, 9, 2, 0, 6, 4, 4, 0, 7},
            {0, 0, 0, 7, 6, 9, 1, 1, 8, 1, 4, 3, 4, 8, 9, 4, 8, 5, 3, 6},
            {0, 0, 0, 0, 6, 3, 7, 4, 9, 5, 8, 4, 1, 4, 3, 2, 8, 4, 3, 3},
            {0, 0, 0, 0, 0, 7, 6, 6, 6, 5, 6, 7, 9, 7, 1, 4, 5, 9, 7, 5},
            {0, 0, 0, 0, 0, 0, 8, 9, 4, 1, 2, 3, 4, 6, 8, 8, 4, 8, 8, 0},
            {0, 0, 0, 0, 0, 0, 0, 6, 9, 5, 3, 0, 6, 3, 4, 3, 6, 4, 5, 5},
            {0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 6, 1, 9, 0, 2, 4, 0, 7, 4},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 3, 3, 9, 3, 8, 1, 6, 4, 9},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 4, 3, 1, 0, 4, 2, 9, 7, 4},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 6, 0, 7, 2, 2, 6, 3, 4},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 9, 7, 8, 5, 3, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 4, 9, 4, 2, 9},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 7, 0, 3, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 3, 6, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 9, 3, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    int result;


    public BF() {
        m = map.length;
        n = map[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i < j) {
                    map[j][i] = map[i][j];
                }
            }
        }
        result = Integer.MAX_VALUE;
    }

    void permutation(int[] ss, int i) {
        if (ss == null || i < 0 || i > ss.length) {
            return;
        }
        if (i == ss.length) {
//            result = Math.min(result, solve(ss));
            int t = solve(ss);
            if (t < result) {
                result = t;
                System.out.println(result);
            }

        } else {
            for (int j = i; j < ss.length; j++) {
                int temp = ss[j];
                ss[j] = ss[i];
                ss[i] = temp;
                permutation(ss, i + 1);
                temp = ss[j];
                ss[j] = ss[i];
                ss[i] = temp;
            }
        }
    }

    public int solve(int[] p) {
        int tmp = 0;
        for (int i = 0; i < p.length - 1; ++i) {
            tmp += map[p[i]][p[i + 1]];
        }
        tmp += map[p[0]][p[p.length - 1]];
        return tmp;
    }

    public static void main(String args[]) {
        BF bf = new BF();
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        bf.permutation(a, 0);
    }
}
