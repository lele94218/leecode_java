package com.terryx.leecode;

/**
 * @author taoranxue on 8/3/17 5:45 PM.
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[0][0];
        int[][] mat = new int[n][n];
        int rmx = n, rmn = 0, cmx = n, cmn = 0;
        int cnt = 0;
        while (rmn < rmx && cmn < cmx) {
            for (int i = rmn; i < rmx; ++i) {
                mat[cmn][i] = ++cnt;
            }
            cmn++;

            for (int j = cmn; j < cmx; ++j) {
                mat[j][rmx - 1] = ++cnt;
            }

            rmx--;

            for (int i = rmx - 1; i >= rmn; --i) {
                mat[cmx - 1][i] = ++cnt;
            }

            cmx--;

            for (int j = cmx - 1; j >= cmn; --j) {
                mat[j][rmn] = ++cnt;
            }

            rmn++;

        }

        return mat;
    }
}
