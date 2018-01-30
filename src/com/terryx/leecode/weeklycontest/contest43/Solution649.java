package com.terryx.leecode.weeklycontest.contest43;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taoranxue on 8/1/17 6:02 PM.
 */
public class Solution649 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < senate.length(); ++i) {
            if (senate.charAt(i) == 'R') q1.offer(i);
            else q2.offer(i);
        }

        int len = senate.length();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int tr = q1.poll(), td = q2.poll();
            if (tr < td) {
                q1.offer(tr + len);
            } else {
                q2.offer(td + len);
            }
        }

        if (!q1.isEmpty()) return "Radiant";
        else return "Dire";
    }
}
