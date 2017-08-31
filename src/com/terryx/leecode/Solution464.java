package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/31/17 10:48 AM.
 */
public class Solution464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger + 1 >= desiredTotal) return false;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        Map<Integer, Boolean> maps[] = new Map[desiredTotal + 1];
        int state = (1 << maxChoosableInteger) - 1;
        return canWin(state, desiredTotal, maxChoosableInteger, maps);
    }

    private boolean canWin(int state, int total, int max, Map<Integer, Boolean>[] maps) {
        // System.out.println(state + " " + total);
        if (maps[total] == null) maps[total] = new HashMap<>();
        if (maps[total].containsKey(state)) return maps[total].get(state);
        boolean ret = false;
        for (int i = max - 1; i >= 0; --i) {
            int t = 1 << i;
            if ((t & state) == t) {
                int nextState = (t ^ state);
                if (total - (i + 1) <= 0) {
                    ret = true;
                    break;
                }

                if (!canWin(nextState, total - (i + 1), max, maps)) {
                    ret = true;
                    break;
                }
            }
        }
        maps[total].put(state, ret);
        return ret;
    }
}
