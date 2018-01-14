package com.terryx.leecode.contest67;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 1/13/18 10:31 PM.
 */
public class Solution765 {
    public int minSwapsCouples(int[] row) {
        if (row == null) {
            return 0;
        }

        int map[] = new int[row.length];
        for (int i = 0; i < row.length; ++i) {
            map[row[i]] = i;
        }
        return dfs(row, 0, map);
    }

    private int dfs(int[] row, int cur, int[] map) {
        if (cur >= row.length) {
            return 0;
        }
        //System.out.println(cur);
        System.out.println(Utils.debug(row));
        int first = row[cur], second = row[cur + 1];
        if ((first % 2 == 0 && first + 1 == second) || (first % 2 == 1 && first - 1 == second)) {
            return dfs(row, cur + 2, map);
        }
        int swapVal = getSwapVal(first);
        swap(row, cur + 1, map[swapVal]);
        map[second] = map[swapVal];
        map[swapVal] = cur + 1;

        int swap0 = dfs(row, cur + 2, map);

        swapVal = getSwapVal(second);
        swap(row, cur + 1, map[swapVal]);
        map[swapVal] = map[second];
        map[second] = cur + 1;


        swapVal = getSwapVal(second);
        //swap(row, cur, getSwapIndex(second, map));
        int swap1 = dfs(row, cur + 2, map);
        //swap(row, cur, getSwapIndex(second, map));
        return 1 + Math.min(swap0, swap1);
    }

    private int getSwapVal(int val) {
        if (val % 2 == 0) {
            return val + 1;
        } else {
            return val - 1;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Solution765 m = new Solution765();
        System.out.println(m.minSwapsCouples(new int[]{0, 9, 2, 1, 4, 3, 6, 5, 8, 7}));
    }
}
