package com.terryx.leecode.contest69;

import java.util.*;

/**
 * @author taoranxue on 1/27/18 10:09 PM.
 */
public class Solution773 {
    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }

        int step = 0;
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        Queue<int[][]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(board);
        visited.add(board2Number(board));
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int t = 0; t < size; ++t) {
                int[][] currBoard = queue.poll();
                //System.out.println(board2Number(currBoard) + " " + step);
                if (board2Number(currBoard) == 123450) {
                    flag = true;
                    break;
                }
                for (int i = 0; i < 2; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        if (currBoard[i][j] == 0) {
                            for (int m = 0; m < 4; ++m) {
                                int nx = i + dx[m], ny = j + dy[m];
                                if (nx >= 0 && nx < 2 && ny >= 0 && ny < 3) {
                                    swap(currBoard, i, j, nx, ny);
                                    if (!visited.contains(board2Number(currBoard))) {
                                        visited.add(board2Number(currBoard));
                                        queue.add(copyBoard(currBoard));
                                    }
                                    swap(currBoard, i, j, nx, ny);

                                }
                            }
                        }
                    }
                }

            }
            if (flag) {
                break;
            }
            step++;
        }
        return flag ? step : -1;
    }

    private void swap(int[][] board, int ix, int iy, int jx, int jy) {
        int tmp = board[ix][iy];
        board[ix][iy] = board[jx][jy];
        board[jx][jy] = tmp;
    }

    private int[][] copyBoard(int board[][]) {
        int[][] r = new int[2][3];
        r[0][0] = board[0][0];
        r[0][1] = board[0][1];
        r[0][2] = board[0][2];
        r[1][0] = board[1][0];
        r[1][1] = board[1][1];
        r[1][2] = board[1][2];
        return r;
    }

    private int board2Number(int[][] board) {
        int res = 0;
        for (int i = 0; i < 3; ++i) {
            res = res * 10 + board[0][i];
        }
        for (int i = 0; i < 3; ++i) {
            res = res * 10 + board[1][i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution773 m = new Solution773();
        System.out.println(m.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
        System.out.println(m.slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
        System.out.println(m.slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
        System.out.println(m.slidingPuzzle(new int[][]{{3, 2, 4}, {1, 5, 0}}));
    }
}
