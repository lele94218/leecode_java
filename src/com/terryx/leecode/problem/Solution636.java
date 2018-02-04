package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/19/17 5:58 PM.
 */
public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null) return new int[0];
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int cur = -1, now = 0, time = -1;
        for (String log : logs) {
            String[] times = log.split(":");
            if ("start".equals(times[1])) {
                time = Integer.parseInt(times[2]);
                if (cur != -1) {
                    res[cur] += time - now;
                    stack.push(cur);
                }
                cur = Integer.parseInt(times[0]);
            }
            if ("end".equals(times[1])) {
                time = Integer.parseInt(times[2]) + 1;
                res[cur] += time - now;
                if (!stack.isEmpty()) {
                    cur = stack.pop();
                } else {
                    cur = -1;
                }

            }
            now = time;
        }
        return res;
    }
}
