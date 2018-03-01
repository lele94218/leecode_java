package com.terryx.leecode.weeklycontest.contest49;

import java.util.*;

/**
 * @author taoranxue on 3/1/18 3:19 PM.
 */
public class Solution675 {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        int map[][] = new int[m][n];
        Map<Integer, Integer> trees = new TreeMap<>();
        int i = 0, j = 0;
        for (List<Integer> list : forest) {
            for (Integer c : list) {
                if (c > 0) {
                    trees.put(c, i * n + j);
                    map[i][j++] = 1;
                } else map[i][j++] = 0;
            }
            i++;
            j = 0;
        }

        int from = 0, res = 0;
        for (Integer tree : trees.keySet()) {
            int to = trees.get(tree);
            int dist = shortest(map, m, n, from, to);
            if (dist == -1) {
                return -1;
            }
            res += dist;
            from = to;
        }

        return res;
    }

    private int shortest(int map[][], int m, int n, int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        int dx[] = new int[]{-1, 1, 0, 0}, dy[] = new int[]{0, 0, -1, 1};
        boolean vist[] = new boolean[m * n];
        queue.offer(from);
        vist[from] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Integer cur = queue.poll();
                if (cur == to) {
                    return level;
                }
                int x = cur / n, y = cur % n;
                for (int k = 0; k < 4; ++k) {
                    int nx = x + dx[k], ny = y + dy[k];
                    int ncode = nx * n + ny;
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] == 1 && !vist[ncode]) {
                        queue.offer(ncode);
                        vist[ncode] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }


}
