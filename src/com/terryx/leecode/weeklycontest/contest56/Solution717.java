package com.terryx.leecode.weeklycontest.contest56;

import java.util.*;

/**
 * @author taoranxue on 2/6/18 11:23 PM.
 */
public class Solution717 {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        return solve(bits, bits.length - 2);
    }

    private boolean solve(int bits[], int cur) {
        if (cur < 0) {
            return true;
        }
        if (bits[cur] == 1) {
            if (cur - 1 < 0) {
                return false;
            }
            return bits[cur - 1] == 1 && solve(bits, cur - 2);
        }

        return solve(bits, cur - 2) || solve(bits, cur - 1);
    }

    public static void main(String[] args) {
        Solution717 m = new Solution717();
        System.out.println(m.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(m.isOneBitCharacter(new int[]{1, 1, 1, 0}));
        System.out.println(m.isOneBitCharacter(new int[]{0}));
        System.out.println(m.isOneBitCharacter(new int[]{1, 0, 1, 0}));
        System.out.println(m.isOneBitCharacter(new int[]{1, 0, 0, 0}));
    }
}
