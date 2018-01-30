package com.terryx.leecode.weeklycontest.contest48;

import java.util.*;

/**
 * @author taoranxue on 9/2/17 10:32 PM.
 */
public class Solution672 {
    private int init = 0;
    public int flipLights(int n, int m) {
        if (n > 6) n = 6;
        if (m > 10) m = 10;
        int state = (1 << n) - 1;
        Map<Integer, Boolean> map = new HashMap<>();
        init = m;
        dfs(state, n, m, map);
        return map.keySet().size();
    }

    private boolean dfs(int state, int len, int m, Map<Integer, Boolean> map) {
        if (map.keySet().size() >= (1 << len)) return true;
//        if (map.containsKey(state)) return;
////        System.out.println(state);
//        if (m < init)
//            map.put(state, true);
        if (m == 0) {
            map.put(state, true);
            return true;
        }
        int newState = state;
        // 1. all flip on
        for (int i = 0; i < len; ++ i) {
            int t = 1 << i;
            newState ^= t;
        }
        dfs(newState, len, m - 1, map);

        // 2. flip even
        newState = state;
        for (int i = 0; i < len; ++ i) if (((i + 1) % 2) == 0){
            int t = 1 << i;
            newState ^= t;
        }
        dfs(newState, len, m - 1, map);


        // 3. flip odd
        newState = state;
        for (int i = 0; i < len; ++ i) if (((i + 1) % 2) == 1){
            int t = 1 << i;
            newState ^= t;
        }
        dfs(newState, len, m - 1, map);



        // 3. flip 3k + 1
        newState = state;
        for (int i = 0; i < len; ++ i) if (((i + 1) % 3) == 1){
            int t = 1 << i;
            newState ^= t;
        }
        dfs(newState, len, m - 1, map);

        return false;
    }
}
