package com.terryx.leecode.weeklycontest.contest73;

import java.util.*;

/**
 * @author taoranxue on 2/24/18 9:46 PM.
 */
public class Solution789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int minTime = Integer.MAX_VALUE;
        int myTime = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            minTime = Math.min(minTime, Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]));
        }
        return minTime > myTime;
    }

    public static void main(String[] args) {
        Solution789 m = new Solution789();
        System.out.println(m.escapeGhosts(new int[][]{{1, 0}, {0, 3}}, new int[]{0, 1}));
        System.out.println(m.escapeGhosts(new int[][]{{1, 0}}, new int[]{2, 0}));
        System.out.println(m.escapeGhosts(new int[][]{{2, 0}}, new int[]{1, 0}));
    }
}
