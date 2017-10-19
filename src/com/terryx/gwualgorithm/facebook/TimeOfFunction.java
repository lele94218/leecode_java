package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/18/17 8:41 PM.
 */
public class TimeOfFunction {
    static class Pair {
        int id, time;

        Pair(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int res[] = new int[n];
        if (logs == null || logs.size() == 0) {
            return res;
        }
        Deque<Pair> stack = new ArrayDeque<>();
        Pair cur = null;
        int time = 0;
        for (String log : logs) {
            String[] strs = log.split(":");
            int now = Integer.parseInt(strs[2]);
            if ("start".equals(strs[1])) {
                if (cur != null) {
                    cur.time += (now - time);
                    stack.push(cur);
                }
                cur = new Pair(Integer.parseInt(strs[0]), 0);
            } else if ("end".equals(strs[1])) {
                now += 1;
                cur.time += (now - time);
                res[cur.id] += cur.time;
                if (!stack.isEmpty()) {
                    cur = stack.pop();
                }
            }
            time = now;
        }
        return res;
    }
}
