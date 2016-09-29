package com.terryx.main;

import com.terryx.leecode.Solution218;
import com.terryx.leecode.Solution23;

import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    public static void main(String args[]) {
        Solution218 solution218 = new Solution218();
        List<int[]> list = solution218
                .getSkylineByTreeMap(new int[][]{new int[]{0, 10, 22}, new int[]{2, 3, 22}, new int[]{6, 7, 22}});
        for (int[] ints : list) {
            System.out.println(ints[0] + ", " + ints[1]);
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer p, Integer q) {
                return q - p;
            }
        });
        treeMap.put(10, 0);
        treeMap.put(22, 0);
        treeMap.put(22, 0);
        treeMap.put(1, 0);
        System.out.println(treeMap.firstKey());
        treeMap.remove(22);
        System.out.println(treeMap.firstKey());

        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer p, Integer q) {
                return q - p;
            }
        });
        System.out.println("pq:");
        pq.offer(10);
        pq.offer(22);
        pq.offer(22);
        pq.offer(1);
        System.out.println(pq.peek());
        pq.remove(22);
        System.out.println(pq.peek());
        pq.remove(22);
        System.out.println(pq.peek());

    }

}
