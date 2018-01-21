package com.terryx.leecode.contest68;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 10:20 PM.
 */
public class Solution768 {

    static class Pair {
        int index, val;
        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i) {
            list.add(new Pair(i, arr[i]));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.val - b.val;
            }
        });

        for (int i = 0; i < list.size(); ++ i) {
            Pair pair = list.get(i);
            arr[pair.index] = i;
        }

        //System.out.println(Utils.debug(arr));

        int start = 0, cnt = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; ++ i) {
            queue.offer(arr[i]);
            //System.out.println(queue);
            if (start == queue.peek()) {
                int max = 0;
                for (Integer a : queue) {
                    max = Math.max(max, a);
                }
                if (max == i) {
                    //System.out.println("ok");
                    start = i + 1;
                    cnt++;
                    while (!queue.isEmpty()) {
                        queue.poll();
                    }
                }
            }
        }
        return cnt;
    }
}
