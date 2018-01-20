package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 5:53 PM.
 */
public class Solution305 {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return res;
        }

        int parent[] = new int[m * n], rank[] = new int[m * n];
        Arrays.fill(parent, -1);
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        int cnt = 0;
        for (int i = 0; i < positions.length; ++i) {
            int x = positions[i][0], y = positions[i][1], code = x * n + y;
            if (parent[code] >= 0) {
                continue;
            }
            parent[code] = code;
            cnt++;
            for (int k = 0; k < 4; ++k) {
                int nx = x + dx[k], ny = y + dy[k], ncode = nx * n + ny;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && parent[ncode] >= 0) {
                    if (unite(ncode, code, parent, rank)) {
                        cnt--;
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }

    private int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    private boolean unite(int x, int y, int[] parent, int[] rank) {
        x = find(x, parent);
        y = find(y, parent);
        if (x == y) {
            return false;
        }
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
        }
        return true;
    }
}
