package com.terryx.challenge.search;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 3/1/18 5:59 PM.
 */
public class POJ2157 {
    public static void main(String[] args) {
        int m, n;
        char map[][] = new char[25][25];
        boolean vist[] = new boolean[25 * 25];
        int key[] = new int[15];
        Scanner in = new Scanner(System.in);
        int dx[] = new int[]{-1, 1, 0, 0}, dy[] = new int[]{0, 0, -1, 1};
        while (in.hasNext()) {
            Arrays.fill(vist, false);
            Arrays.fill(key, 0);
            m = in.nextInt();
            n = in.nextInt();
            if (m == 0 && n == 0) break;
            int start = 0, end = 0;
            for (int i = 0; i < m; ++i) {
                String line = in.next();
                for (int j = 0; j < n; ++j) {
                    char c = line.charAt(j);
                    if (c == 'S') {
                        start = i * n + j;
                        c = '.';
                    } else if (c == 'G') {
                        end = i * n + j;
                        c = '.';
                    } else if (Character.isLowerCase(c)) {
                        key[c - 'a']++;
                    }
                    map[i][j] = c;
                }
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(start);
            vist[start] = true;
            boolean flag = false;
            for (int itr = 0; itr <= m * n && !queue.isEmpty(); ++itr) {
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    int cur = queue.poll();
                    if (cur == end) {
                        flag = true;
                        break;
                    }
                    int x = cur / n, y = cur % n;
                    char c = map[x][y];
                    if (Character.isUpperCase(c)) {
                        if (key[Character.toLowerCase(c) - 'a'] == 0) {
                            vist[cur] = true;
                        } else {
                            queue.offer(cur);
                            continue;
                        }
                    }

                    for (int k = 0; k < 4; ++k) {
                        int nx = x + dx[k], ny = y + dy[k], ncode = nx * n + ny;
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] != 'X' && !vist[ncode]) {
                            c = map[nx][ny];
                            if (Character.isLowerCase(c)) {
                                key[Character.toLowerCase(c) - 'a']--;
                                vist[ncode] = true;
                                queue.offer(ncode);
                            } else if (Character.isUpperCase(c)) {
                                queue.offer(ncode);
                            } else {
                                vist[ncode] = true;
                                queue.offer(ncode);
                            }
                        }
                    }
                }
                if (flag) break;
            }
            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
