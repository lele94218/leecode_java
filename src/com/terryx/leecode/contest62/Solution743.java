package com.terryx.leecode.contest62;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 6:43 PM.
 */
public class Solution743 {
    static class Pair {
        int index, len;

        Pair(int index, int len) {
            this.index = index;
            this.len = len;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0) {
            return 0;
        }

        int dist[] = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int mat[][] = new int[N][N];
        for (int i = 0; i < N; ++ i) {
            Arrays.fill(mat[i], -1);
        }
        for (int time[] : times) {
            mat[time[0] - 1][time[1] - 1] = time[2];
        }
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.len - b.len;
            }
        });
        queue.offer(new Pair(K - 1, 0));
        dist[K - 1] = 0;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int index = cur.index, len = cur.len;
            if (dist[index] < len) {
                continue;
            }
            for (int i = 0; i < N; ++i) {
                int w = mat[index][i];
                if (w >= 0 && (dist[i] > dist[index] + w)) {
                    dist[i] = dist[index] + w;
                    queue.offer(new Pair(i, dist[i]));
                }
            }

        }
        System.out.println(Utils.debug(dist));
        int res = 0;
        for (int i = 0; i < N; ++i) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, dist[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution743 m = new Solution743();
        System.out.println(m.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(m.networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2));
        System.out.println(m.networkDelayTime(new int[][]{{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}}, 5, 5));
    }
}
