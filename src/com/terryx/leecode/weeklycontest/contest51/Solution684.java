package com.terryx.leecode.weeklycontest.contest51;

import java.util.*;

/**
 * @author taoranxue on 2/26/18 9:19 PM.
 */
public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[edges.length];
        Arrays.fill(parent, -1);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[u] == -1) {
                parent[u] = u;
            }
            if (parent[v] == -1) {
                parent[v] = v;
            }
            if (find(u, parent) == find(v, parent)) {
                return new int[]{u, v};
            }
            united(u, v, parent);
        }
        return new int[2];
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
