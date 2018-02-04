package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/31/18 7:01 PM.
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        });
        List<int[]> list = new LinkedList<>();
        for (int[] e : people) {
            list.add(e[1], e);
        }
        int[][] res = new int[people.length][2];
        int idx = 0;
        for (int[] e : list) {
            res[idx++] = e;
        }
        return res;
    }
}
