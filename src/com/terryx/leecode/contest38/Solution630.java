package com.terryx.leecode.contest38;


import java.util.*;

/**
 * @author taoranxue on 6/24/17 9:36 PM.
 */
public class Solution630 {

    public int scheduleCourse(int[][] courses) {

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int s = 0;
        for (int i = 0; i < courses.length; ++ i) {
            s += courses[i][0];
            queue.offer(courses[i][0]);
            while (s > courses[i][1]) {
                s -= queue.poll();
            }
        }
        return queue.size();
    }
}
