package com.terryx.interview.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taoranxue on 6/16/17 5:36 PM.
 */
public class PreparetheBunniesEscape {
    public static class Node {
        public int x, y;
        public boolean remove;
        public int level;

        public Node(int x, int y, int level, boolean remove) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.remove = remove;
        }

    }


    public static int[][] bfs(int x, int y, int maze[][]) {
        int height = maze.length;
        int width = maze[0].length;
        int vist[][] = new int[height][width];
        int mark[][] = new int[height][width];

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                mark[i][j] = -1;
            }
        }
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        Node src = new Node(x, y, 1, true);
//        System.out.println(x + "," + y);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(src);
        vist[x][y] = 1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
//            System.out.println(cur.x + "," + cur.y);
//            System.out.println(cur.level);
            mark[cur.x][cur.y] = cur.level;
            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < height && ny >= 0 && ny < width && vist[nx][ny] != 1) {
                    if (maze[nx][ny] == 0) {
//                        System.out.println(nx + "," + ny + ":" + vist[nx][ny]);
                        queue.offer(new Node(nx, ny, cur.level + 1, cur.remove));
                        vist[nx][ny] = 1;
                    }
                }
            }
        }
        return mark;
    }


    public static int answer(int[][] maze) {
        // Your code goes here.
        int height = maze.length;
        int width = maze[0].length;
        int fromSrc[][] = bfs(0, 0, maze);
        int fromDst[][] = bfs(height - 1, width - 1, maze);

//        for (int i = 0; i < height; ++i) {
//            for (int j = 0; j < width; ++j) {
//                System.out.print(fromSrc[i][j] + ", ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//        for (int i = 0; i < height; ++i) {
//            for (int j = 0; j < width; ++j) {
//                System.out.print(fromDst[i][j] + ", ");
//            }
//            System.out.println();
//        }

        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};


        int res = fromDst[0][0] > 0 ? fromDst[0][0] : Integer.MAX_VALUE;
//        System.out.println(res);

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (maze[i][j] == 1) {
                    int min1 = Integer.MAX_VALUE;
                    int min2 = Integer.MAX_VALUE;
                    for (int k = 0; k < 4; ++k) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < height && ny >= 0 && ny < width) {
                            if (fromSrc[nx][ny] >= 0) min1 = Math.min(min1, fromSrc[nx][ny]);
                            if (fromDst[nx][ny] >= 0) min2 = Math.min(min2, fromDst[nx][ny]);
                        }
                    }
                    if (min1 != Integer.MAX_VALUE && min2 != Integer.MAX_VALUE) {
                        res = Math.min(res, min1 + min2 + 1);
                    }
                }
            }
        }
        return res;

    }

    public static int answer1(int[][] maze) {

        // Your code goes here.
        int height = maze.length;
        int width = maze[0].length;
        int vist[][] = new int[height][width];
//        System.out.println(height + " " + width);

        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        Node src = new Node(0, 0, 1, true);
        Node dst = new Node(height - 1, width - 1, 1, true);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(src);
        int res = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
//            System.out.println(cur.x + " " + cur.y);
            if (cur.x == dst.x && cur.y == dst.y) {
                res = cur.level;
                break;
            }
            vist[cur.x][cur.y] = 1;
            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < height && ny >= 0 && ny < width && vist[nx][ny] != 1) {
                    if (maze[nx][ny] == 1) {
                        if (cur.remove) {
//                            System.out.println("ok");
                            queue.offer(new Node(nx, ny, cur.level + 1, false));
                        }
                    } else {
                        queue.offer(new Node(nx, ny, cur.level + 1, cur.remove));
                    }
                }
            }
        }
        System.out.println("fdsf");
        return res;
    }

    public static void main(String args[]) {
//        int maze[][] = new int[][]{
//                {0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 0},
//                {0, 0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 1, 1},
//                {0, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0}
//        };
//        int maze[][] = new int[][]{
//                {0, 1, 1, 0},
//                {0, 0, 0, 1},
//                {1, 1, 0, 0},
//                {1, 1, 1, 0}
//        };
        int maze[][] = new int[][]{
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(answer(maze));
        System.out.println();
        System.out.println(answer1(maze));
    }
}
