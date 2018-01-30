package com.terryx.leecode.weeklycontest.contest37;

import java.util.ArrayList;

/**
 * @author taoranxue on 6/17/17 9:30 PM.
 */
public class Solution624 {
    public int maxDistance(int[][] arrays) {
        ArrayList<Integer> minL = new ArrayList<>();
        ArrayList<Integer> maxL = new ArrayList<>();
        int indexMin = 0;
        int indexMax = 0;
        int _min = Integer.MAX_VALUE;
        int _max = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.length; ++i) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < arrays[i].length; ++j) {
                if (arrays[i][j] < min) {
                    min = arrays[i][j];
                }
                if (arrays[i][j] > max) {
                    max = arrays[i][j];
                }
            }
            if (min < _min) {
                _min = min;
                indexMin = i;
            }
            if (max > _max) {
                _max = max;
                indexMax = i;
            }
            minL.add(min);
            maxL.add(max);
        }

        int res = Integer.MIN_VALUE;


        for (int i = 0; i < maxL.size(); ++i) {
            if (i != indexMin) {
                res = Math.max(Math.abs(maxL.get(i) - _min), res);
            }
        }

        for (int i = 0; i < minL.size(); ++i) {
            if (i != indexMax) {
                res = Math.max(Math.abs(minL.get(i) - _max), res);
            }
        }

        return res;
    }

    public static void main(String args[]) {

    }
}
