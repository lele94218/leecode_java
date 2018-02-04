package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/25/17 10:35 PM.
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean adj[][] = new boolean[numCourses][numCourses];
        int deg[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            int u = prerequisites[i][0], v = prerequisites[i][1];
            adj[v][u] = true;
            deg[u]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (deg[i] == 0) queue.offer(i);
        }
        int res[] = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[idx++] = cur;
            for (int i = 0; i < numCourses; ++i)
                if (adj[cur][i]) {
                    deg[i]--;
                    if (deg[i] == 0) queue.offer(i);
                }
        }
        return idx == numCourses ? res : new int[0];
    }

    // DFS version. SO SLOW!
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         int[] array = new int[numCourses];
//         for (int k = 0; k < numCourses; ++ k) {
//             array[k] = k;
//         }
//         if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return array;
//         boolean adj[][] = new boolean[numCourses][numCourses];
//         int vist[] = new int[numCourses];
//         Arrays.fill(vist, -1);
//         for (int i = 0; i < prerequisites.length; ++ i) {
//             int u = prerequisites[i][0], v = prerequisites[i][1];
//             vist[u] = vist[v] = 0;
//             adj[v][u] = true;
//         }
//         Stack<Integer> res = new Stack<>();
//         for (int i = 0; i < numCourses; ++ i) if (vist[i] != 2) {
//             if (!dfs(vist, adj, i, numCourses, res)) {
//                 return new int[0];
//             }
//         }

//         int k = 0;
//         while (!res.isEmpty()) {
//             array[k++] = res.pop();
//         }
//         return array;
//     }

//     private boolean dfs(int vist[], boolean adj[][], int cur, int numCourses, Stack<Integer> res) {
//         vist[cur] = 1;
//         for (int i = 0; i < numCourses; ++ i) {
//             if (vist[i] != 2 && adj[cur][i]) {
//                 if (vist[i] == 1) return false;
//                 if (!dfs(vist, adj, i, numCourses, res)) return false;
//             }
//         }
//         res.push(cur);
//         vist[cur] = 2;
//         return true;
//     }
}
