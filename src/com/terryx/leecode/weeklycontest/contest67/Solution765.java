package com.terryx.leecode.weeklycontest.contest67;

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

        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            int first = row[i], second = row[i + 1], swapVal = 0;
            if (first % 2 == 0 && first + 1 == second || first % 2 == 1 && first - 1 == second) {
                continue;
            }
            res++;
            if (first % 2 == 0) {
                swapVal = first + 1;
            } else {
                swapVal = first - 1;
            }

            int swapIndex = map[swapVal];
            swap(row, i + 1, swapIndex);
            map[second] = swapIndex;
            map[swapVal] = i + 1;
        }
        return res;
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
