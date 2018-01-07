package com.terryx.leecode.contest65;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 12/30/17 10:01 PM.
 */
public class Solution755 {
    public int[] pourWater(int[] heights, int V, int K) {
        if (heights == null || heights.length == 0) {
            return heights;
        }

        for (int i = 0; i < V; ++i) {
            System.out.println(i);
            drop(heights, K);
        }
        return heights;
    }

    private void drop(int[] heights, int K) {
        if (K < 0 || K >= heights.length) {
            return;
        }
        System.out.println(Utils.debug(heights));
        int i = 0;
        for (i = K - 1; i >= 0; --i) {
            if (heights[i] > heights[i + 1]) {
                break;
            }
        }
        int left = heights[i + 1], left_ix = i + 1;
        while (i + 1 < heights.length && heights[left_ix] == heights[++i]) {
            left_ix = i;
        }
        for (i = K + 1; i < heights.length; ++i) {
            if (heights[i] > heights[i - 1]) {
                break;
            }
        }
        int right = heights[i - 1], right_ix = i - 1;
        while (i - 1 >= 0 && heights[right_ix] == heights[--i]) {
            right_ix = i;
        }
        if (left == right && left == heights[K]) {
            heights[K]++;
        } else if (left <= right) {
            heights[left_ix]++;
        } else {
            heights[right_ix]++;
        }
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
