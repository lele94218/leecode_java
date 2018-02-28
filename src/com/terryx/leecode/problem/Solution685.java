package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/27/18 1:20 PM.
 */
public class Solution685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int parent[] = new int[edges.length + 1];
        Arrays.fill(parent, -1);
        int[] c1 = null, c2 = null;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] != -1) {
                c1 = new int[]{parent[v], v};
                c2 = new int[]{u, v};
                edge[1] = 0;
            } else {
                parent[v] = u;
            }
        }
        Arrays.fill(parent, -1);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (v == 0) continue;
            if (parent[u] == -1) {
                parent[u] = u;
            }
            if (parent[v] == -1) {
                parent[v] = v;
            }
            if (find(u, parent) == find(v, parent)) {
                if (c1 != null) {
                    return c1;
                }
                return new int[]{u, v};
            }
            united(u, v, parent);
        }
        return c2;
    }

    private int find(int x, int parent[]) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    private void united(int x, int y, int parent[]) {
        x = find(x, parent);
        y = find(y, parent);
        if (x == y) {
            return;
        }
        parent[x] = y;
    }
}
