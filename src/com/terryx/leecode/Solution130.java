package com.terryx.leecode;

/**
 * @author taoranxue on 10/21/16 3:36 PM.
 */
public class Solution130 {
    private int m;
    private int n;

    class UnionFind {
        int[] parents;

        public UnionFind(int num) {
            parents = new int[num];
            for (int i = 0; i < num; ++i) {
                parents[i] = i;
            }
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                parents[qRoot] = pRoot;
            }
        }

        public int find(int node) {
            while (parents[node] != node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }

        boolean isConnected(int p, int q) {
            return (find(p) == find(q));
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        int dummy = m * n;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        uf.union(node(i, j), dummy);
                    } else {
                        if (i > 0 && board[i - 1][j] == 'O') uf.union(node(i, j), node(i - 1, j));
                        if (j > 0 && board[i][j - 1] == 'O') uf.union(node(i, j), node(i, j - 1));
                        if (i < m - 1 && board[i + 1][j] == 'O') uf.union(node(i, j), node(i + 1, j));
                        if (j < n - 1 && board[i][j + 1] == 'O') uf.union(node(i, j), node(i, j + 1));
                    }
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (uf.isConnected(node(i, j), dummy)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int node(int i, int j) {
        return i * n + j;
    }

}
