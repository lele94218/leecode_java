package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/27/16 3:36 PM.
 */
public class Solution218 {
    public List<int[]> getSkylineByTreeMap(int[][] buildings) {
        List<Integer[]> height = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        for (int [] building : buildings) {
            height.add(new Integer[]{building[0], building[2]});
            height.add(new Integer[]{building[1], -building[2]});
        }
        Collections.sort(height, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] p, Integer[] q) {
                if (!Objects.equals(p[0], q[0])) return p[0] - q[0];
                return q[1] - p[1];
            }
        });
        TreeMap<Integer, Integer> mt = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer p, Integer q) {
                return q - p;
            }
        });
        mt.put(0,1);
        int prev = 0;
        for (Integer[] h : height) {
            if (h[1] > 0) {
                Integer cnt = mt.get(h[1]);
                cnt = (cnt == null) ? 1 : cnt + 1;
                mt.put(h[1], cnt);
            } else {
                Integer cnt = mt.get(-h[1]);
                if (cnt == 1) {
                    mt.remove(-h[1]);
                } else {
                    mt.put(-h[1], cnt - 1);
                }
            }
            int cur = mt.firstKey();
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<Integer[]> height = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        for (int [] building : buildings) {
            height.add(new Integer[]{building[0], building[2]});
            height.add(new Integer[]{building[1], -building[2]});
        }
        Collections.sort(height, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] p, Integer[] q) {
                if (!Objects.equals(p[0], q[0])) return p[0] - q[0];
                return q[1] - p[1];
            }
        });
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer p, Integer q) {
                return q - p;
            }
        });
        pq.offer(0);
        int prev = 0;
        for (Integer[] h : height) {
            System.out.println("peek: " + pq.peek());
            if (h[1] > 0) {
                pq.offer(h[1]);
            } else {
                pq.remove(-h[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
