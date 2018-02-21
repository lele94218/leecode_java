package com.terryx.leecode.weeklycontest.contest72;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 2/17/18 9:35 PM.
 */
public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int color[] = new int[N];
        for (int i = 0; i < N; ++i)
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int from = queue.poll();
                    for (int to : graph[from]) {
                        if (color[to] == color[from]) {
                            return false;
                        }
                        if (color[to] == 0) {
                            color[to] = -color[from];
                            queue.offer(to);
                        }
                    }
                }
            }
        return true;
    }

    public static void main(String[] args) {
        Solution785 m = new Solution785();
        System.out.println(m.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(m.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(m.isBipartite(new int[][]{{3}, {3}, {}, {0, 1}, {6}, {}, {4}, {9}, {}, {7}}));
        System.out.println(m.isBipartite(new int[][]{{4}, {}, {4}, {4}, {0, 2, 3}}));
        System.out.println(m.isBipartite(new int[][]{{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}}));
    }
}
