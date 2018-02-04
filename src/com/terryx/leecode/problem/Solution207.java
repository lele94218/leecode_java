package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/25/17 8:53 PM.
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || numCourses <= 1) return true;
        boolean adj[][] = new boolean[numCourses][numCourses];
        int vist[] = new int[numCourses];
        Arrays.fill(vist, -1);
        for (int i = 0; i < prerequisites.length; ++i) {
            int u = prerequisites[i][0], v = prerequisites[i][1];
            vist[u] = 0;
            vist[v] = 0;
            adj[v][u] = true;
        }
        for (int i = 0; i < numCourses; ++i)
            if (vist[i] == 0) {
                if (!dfs(vist, adj, i, numCourses)) return false;
            }
        return true;
    }

    private boolean dfs(int vist[], boolean adj[][], int cur, int n) {
        vist[cur] = 1;
        for (int i = 0; i < n; ++i) {
            if (vist[i] != 2 && adj[cur][i]) {
                if (vist[i] == 1) return false;
                if (!dfs(vist, adj, i, n)) return false;
            }
        }
        vist[cur] = 2;
        return true;
    }
}
