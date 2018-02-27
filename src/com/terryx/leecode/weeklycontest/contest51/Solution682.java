package com.terryx.leecode.weeklycontest.contest51;

import java.util.*;

/**
 * @author taoranxue on 2/26/18 8:56 PM.
 */
public class Solution682 {
    public int calPoints(String[] ops) {
        int point = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if ("+".equals(op)) {
                int p1 = stack.pop();
                int p2 = stack.peek();
                int p = p1 + p2;
                stack.push(p1);
                stack.push(p);
                point += p;
            } else if ("D".equals(op)) {
                int p = stack.peek() * 2;
                point += p;
                stack.push(p);
            } else if ("C".equals(op)) {
                int p = stack.pop();
                point -= p;
            } else {
                int p = Integer.parseInt(op);
                point += p;
                stack.push(p);
            }
        }
        return point;
    }
}
