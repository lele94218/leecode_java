package com.terryx.main;

import com.terryx.leecode.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[][] a = {{1, 2}, {3, 4}};
        solution48.rotate(a);
        for (int i = 0; i < a[0].length; ++i) {
            for (int j = 0; j < a[0].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
