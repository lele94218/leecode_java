package com.terryx.challenge.search;

import java.util.*;

/**
 * @author taoranxue on 3/1/18 6:37 PM.
 */
public class HDU1429 {
    public static void main(String[] args) {
        int m, n, t;
        char map[][] = new char[20][20];
        boolean vist[][] = new boolean[20 * 20][1 << 10];
        int dx[] = new int[]{-1, 1, 0, 0}, dy[] = new int[]{0, 0, -1, 1};
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            m = in.nextInt();
            n = in.nextInt();
            t = in.nextInt();
            int start = 0, end = 0;
            for (int i = 0; i < m; ++i) {
                String line = in.next();
                for (int j = 0; j < n; ++j) {
                    char c = line.charAt(j);
                    map[i][j] = c;
                    if (c == '@') {
                        start = i * n + j;
                    }
                    if (c == '^') {
                        end = i * n + j;
                    }
                    Arrays.fill(vist[i * n + j], false);
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{start, 0});
            vist[start][0] = true;
            int level = 0;
            boolean flag = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    int[] cur = queue.poll();
                    int code = cur[0], state = cur[1];
                    if (code == end) {
                        flag = true;
                        break;
                    }
                    int x = code / n, y = code % n;
//                    System.out.println(x + " " + y);
                    for (int k = 0; k < 4; ++k) {
                        int nx = x + dx[k], ny = y + dy[k], ncode = nx * n + ny;
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] != '*') {
                            char c = map[nx][ny];
                            int nxtState = state;
                            if (c != '.' && c != '^') {
                                if (Character.isLowerCase(c)) {
                                    // exist key
                                    int keyId = c - 'a';
                                    nxtState = state | (1 << keyId);
                                } else if (Character.isUpperCase(c)) {
                                    // exist door
                                    int doorId = c - 'A';
                                    if ((state & (1 << doorId)) == 0) continue;
                                }
                            }
                            if (!vist[ncode][nxtState]) {
//                                System.out.println(">>>" + nx + " " + ny);
                                queue.offer(new int[]{ncode, nxtState});
                                vist[ncode][nxtState] = true;
                            }
                        }
                    }
                }
                if (flag) break;
                level++;
            }
            if (flag && level < t) System.out.println(level);
            else System.out.println(-1);
        }
    }
}
