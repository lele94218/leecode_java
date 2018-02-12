package com.terryx.leecode.weeklycontest.contest71;

import java.util.*;

/**
 * @author taoranxue on 2/10/18 10:11 PM.
 */
public class Solution780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        System.out.println(sx + " " + sy + ", " + tx + " " + ty);
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx && sy == ty) {
            return true;
        }
        if (tx > ty) {
            int tmp = tx;
            tx = ty;
            ty = tmp;

            tmp = sx;
            sx = sy;
            sy = tmp;
        }
        int next = ty % tx == 0 ? tx : ty % tx;
        return (sx == tx && (sy - next) % sx == 0) || next != ty && reachingPoints(sx, sy, tx, next);
    }

    public static void main(String[] args) {
        Solution780 m = new Solution780();
        System.out.println(m.reachingPoints(9, 10, 9, 19));
        System.out.println(m.reachingPoints(10, 4, 10, 20));
        System.out.println(m.reachingPoints(3, 3, 12, 9));
        System.out.println(m.reachingPoints(9, 5, 12, 8));
    }
}
