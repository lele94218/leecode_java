package com.terryx.leecode.weeklycontest.contest65;

import com.terryx.main.Utils;

/**
 * @author taoranxue on 12/30/17 10:01 PM.
 */
public class Solution755 {
    public int[] pourWater(int[] heights, int V, int K) {
        if (heights == null || heights.length == 0) {
            return heights;
        }
        while(V > 0) {
            int index = K;
            for (int i = K - 1; i >= 0; -- i) {
                if (heights[i] > heights[index]) {
                    break;
                }
                if (heights[i] < heights[index]) {
                    index = i;
                }
            }
            if (heights[index] < heights[K]) {
                heights[index]++;
                V--;
                continue;
            }
            index = K;
            for (int i = K + 1; i < heights.length; ++ i) {
                if (heights[i] > heights[index]) {
                    break;
                }
                if (heights[i] < heights[index]) {
                    index = i;
                }
            }
            if (heights[index] < heights[K]) {
                heights[index]++;
            } else {
                heights[K]++;
            }
            V--;
        }
        return heights;
    }

    public static void main(String[] args) {
        Solution755 m = new Solution755();
        //System.out.println(Utils.debug(m.pourWater(new int[]{1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1}, 5, 5)));
        //System.out.println(Utils.debug(m.pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4, 3)));
        //System.out.println(Utils.debug(m.pourWater(new int[]{1, 2, 3, 4}, 2, 2)));
        //System.out.println(Utils.debug(m.pourWater(new int[]{3, 1, 3}, 5, 1)));
        System.out.println(Utils.debug(m.pourWater(new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1},5, 2)));

    }
}
