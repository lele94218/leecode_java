package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/5/18 4:48 PM.
 */
public class Solution261 {
    public boolean validTree(int n, int[][] edges) {
        int parent[] = new int[n], rank[] = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (find(x, parent) == find(y, parent)) {
                return false;
            }
            unite(x, y, parent, rank);
        }
        return edges.length == n - 1;
    }

    private int find(int x, int parent[]) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    private void unite(int x, int y, int parent[], int rank[]) {
        x = find(x, parent);
        y = find(y, parent);
        if (x == y) {
            return;
        }
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
        }
    }
}
