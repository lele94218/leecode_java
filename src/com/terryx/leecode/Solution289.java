package com.terryx.leecode;

/**
 * @author taoranxue on 8/10/17 3:54 PM.
 */
public class Solution289 {
    public void gameOfLife(int[][] board) {
        /* live -> live: 1
         * live -> die : 2
         * die  -> die : 0
         * die  -> live: 3
         */
        if (board == null || board.length == 0) return;
        int height = board.length, width = board[0].length;

        int dx[] = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
        int dy[] = new int[]{0, 0, -1, 1, 1, 1, -1, -1};

        for (int x = 0; x < height; ++ x) {
            for (int y = 0; y < width; ++ y) {
                int cntLive = 0;
                for (int i = 0; i < dx.length; ++ i) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < height && ny >= 0 && ny < width
                            && (board[nx][ny] == 1 || board[nx][ny] == 2)) {
                        cntLive ++;
                    }
                }

                if (board[x][y] == 1 || board[x][y] == 2) {
                    // live cell
                    if (cntLive < 2 || cntLive > 3) {
                        board[x][y] = 2;
                    }
                } else {
                    // die cell
                    if (cntLive == 3) {
                        board[x][y] = 3;
                    }
                }
            }
        }

        for (int x = 0; x < height; ++ x) {
            for (int y = 0; y < width; ++ y) {
                if (board[x][y] == 2) board[x][y] = 0;
                if (board[x][y] == 3) board[x][y] = 1;
            }
        }

    }
}
