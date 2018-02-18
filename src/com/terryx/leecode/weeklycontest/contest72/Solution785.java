package com.terryx.leecode.weeklycontest.contest72;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 2/17/18 9:35 PM.
 */
public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int G[][] = new int[V][V];
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < graph[i].length; ++j) {
//                color[graph[i][j]] = -2;
                G[i][graph[i][j]] = 1;
            }
        }
//        color[0] = 1;

//        System.out.println(Utils.debug(color));

//        for (int i = 0; i < V; ++i) {
//            if (color[i] == -1) {
//                return false;
//            }
//        }
        for (int i = 0; i < V; ++i) {
            if (color[i] == -1) {
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);

                while (!q.isEmpty()) {
                    int u = q.poll();

                    if (G[u][u] == 1) {
                        return false;
                    }

                    for (int v = 0; v < V; ++v) {
                        if (G[u][v] == 1 && color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.offer(v);
                        } else if (G[u][v] == 1 && color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }

//        System.out.println(Utils.debug(color));

        return true;
    }

    public static void main(String[] args) {
        Solution785 m = new Solution785();
//        System.out.println(m.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
//        System.out.println(m.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
//        System.out.println(m.isBipartite(new int[][]{{3}, {3}, {}, {0, 1}, {6}, {}, {4}, {9}, {}, {7}}));
//        System.out.println(m.isBipartite(new int[][]{{4}, {}, {4}, {4}, {0, 2, 3}}));
        System.out.println(m.isBipartite(new int[][]{{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}}));
    }
}
