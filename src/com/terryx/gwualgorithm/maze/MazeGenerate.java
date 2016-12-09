package com.terryx.gwualgorithm.maze;

import java.util.*;

/**
 * @author taoranxue on 12/8/16 6:32 PM.
 */
public class MazeGenerate {
    private int m; //y
    private int n; //x
    private boolean[][] north;     // is there a wall to north of cell i, j
    private boolean[][] east;
    private boolean[][] south;
    private boolean[][] west;
    private boolean[][] visited;

    private int[][] path;
    private int[][] bfsPath;

    private boolean flag;
    private int k;


    public MazeGenerate(int m, int n) {
        this.m = m;
        this.n = n;

        init();
        generate(1, 1);
    }

    public void doit() {
        flag = false;
        k = 0;
        for (int x = 1; x <= n; ++x) {
            for (int y = 1; y <= m; ++y) {
                path[x][y] = -1;
            }
        }
        for (int x = 1; x <= n; ++x) {
            for (int y = 1; y <= m; ++y) {
                visited[x][y] = false;
            }
        }
        System.out.println();
        System.out.println("DFS");
        dfs(1, m);

        draw();

        System.out.println();


        for (int x = 1; x <= n; ++x) {
            for (int y = 1; y <= m; ++y) {
                path[x][y] = -1;
            }
        }
        for (int x = 1; x <= n; ++x) {
            for (int y = 1; y <= m; ++y) {
                visited[x][y] = false;
            }
        }

        flag = false;
        printDfs(1, m, new ArrayList<>());
        path[1][m] = 10;
        draw();

        System.out.println();

        bfsPath = new int[n + 2][m + 2];

        for (int x = 1; x <= n; ++x) {
            for (int y = 1; y <= m; ++y) {
                path[x][y] = -1;
                bfsPath[x][y] = -1;
            }
        }

        for (int x = 1; x <= n; ++x) {
            for (int y = 1; y <= m; ++y) {
                visited[x][y] = false;
            }
        }


        System.out.println("BFS");
        k = 0;
        bfs(1, m);
        bfsPath[1][m] = 10;
        bfsPath[n][1] = 10;

        draw();
        System.out.println();
        draw0();


    }

    private void dfs(int x, int y) {
        if (x == 0 || y == 0 || x == n + 1 || y == m + 1) return;
        if (flag || visited[x][y]) return;
        if (x == n && y == 1) {
            path[x][y] = (k++) % 10;
            flag = true;
            return;
        }

        visited[x][y] = true;
        path[x][y] = (k++) % 10;

        if (!north[x][y]) dfs(x, y + 1);
        if (!east[x][y]) dfs(x + 1, y);
        if (!south[x][y]) dfs(x, y - 1);
        if (!west[x][y]) dfs(x - 1, y);

    }

    private void printDfs(int x, int y, ArrayList<Integer[]> list) {
        if (x == 0 || y == 0 || x == n + 1 || y == m + 1) return;
        if (flag || visited[x][y]) return;
        if (x == n && y == 1) {
            for (Integer[] is : list) {
                path[is[0]][is[1]] = 10;
            }
            flag = true;
        }


        visited[x][y] = true;
        if (!north[x][y]) {
            list.add(new Integer[]{x, y + 1});
            printDfs(x, y + 1, list);
            list.remove(list.size() - 1);
        }
        if (!east[x][y]) {
            list.add(new Integer[]{x + 1, y});
            printDfs(x + 1, y, list);
            list.remove(list.size() - 1);
        }
        if (!south[x][y]) {
            list.add(new Integer[]{x, y - 1});
            printDfs(x, y - 1, list);
            list.remove(list.size() - 1);
        }
        if (!west[x][y]) {
            list.add(new Integer[]{x - 1, y});
            printDfs(x - 1, y, list);
            list.remove(list.size() - 1);
        }

        visited[x][y] = false;
    }

    private void bfs(int x, int y) {

        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{x, y});

        int[] p = new int[m * n + 10];

        while (!queue.isEmpty()) {
            Integer[] v = queue.poll();
            int px = v[0];
            int py = v[1];

            visited[px][py] = true;
            int parent = (py - 1) * n + px;
            path[px][py] = (k++) % 10;
            if (px == n && py == 1) {
                parent = encode(px, py);
                while (p[parent] != 0 && p[parent] != parent) {
                    int _v = parent;
                    int _y = _v / n + 1;
                    int _x = _v % n;
                    if (_x == 0) _x = n;
                    bfsPath[_x][_y] = 10;

                    parent = p[parent];
                }
                break;
            }

            if (!north[px][py] && check(px, py + 1) && !visited[px][py + 1]) {
//                System.out.println("n");
                p[encode(px, py + 1)] = parent;
                queue.offer(new Integer[]{px, py + 1});
            }
            if (!east[px][py] && check(px + 1, py) && !visited[px + 1][py]) {
//                System.out.println("e");
                p[encode(px + 1, py)] = parent;
                queue.offer(new Integer[]{px + 1, py});
            }
            if (!south[px][py] && check(px, py - 1) && !visited[px][py - 1]) {
//                System.out.println("s");
                p[encode(px, py - 1)] = parent;
                queue.offer(new Integer[]{px, py - 1});
            }
            if (!west[px][py] && check(px - 1, py) && !visited[px - 1][py]) {
//                System.out.println("w");
                p[encode(px - 1, py)] = parent;
                queue.offer(new Integer[]{px - 1, py});
            }
        }
    }

    private int encode(int x, int y) {
        return (y - 1) * n + x;
    }

    boolean check(int x, int y) {
        if (x == 0 || y == 0 || x == n + 1 || y == m + 1) {
            return false;
        }
        return true;
    }

    private void generate(int x, int y) {
        visited[x][y] = true;
        Random random = new Random();

        // while there is an unvisited neighbor
        while (!visited[x][y + 1] || !visited[x + 1][y] || !visited[x][y - 1] || !visited[x - 1][y]) {

            // pick random neighbor (could use Knuth's trick instead)
            while (true) {
                int r = random.nextInt(4);
                if (r == 0 && !visited[x][y + 1]) {
                    north[x][y] = false;
                    south[x][y + 1] = false;
                    generate(x, y + 1);
                    break;
                } else if (r == 1 && !visited[x + 1][y]) {
                    east[x][y] = false;
                    west[x + 1][y] = false;
                    generate(x + 1, y);
                    break;
                } else if (r == 2 && !visited[x][y - 1]) {
                    south[x][y] = false;
                    north[x][y - 1] = false;
                    generate(x, y - 1);
                    break;
                } else if (r == 3 && !visited[x - 1][y]) {
                    west[x][y] = false;
                    east[x - 1][y] = false;
                    generate(x - 1, y);
                    break;
                }
            }
        }
    }

    private void init() {
        path = new int[n + 2][m + 2];
        // initialize border cells as already visited
        visited = new boolean[n + 2][m + 2];
        for (int x = 0; x < n + 2; x++) {
            visited[x][0] = true;
            visited[x][m + 1] = true;
        }
        for (int y = 0; y < m + 2; y++) {
            visited[0][y] = true;
            visited[n + 1][y] = true;
        }
        for (int x = 1; x <= n; ++x) {
            for (int y = 1; y <= m; ++y) {
                path[x][y] = -1;
            }
        }

        // initialze all walls as present
        north = new boolean[n + 2][m + 2];
        east = new boolean[n + 2][m + 2];
        south = new boolean[n + 2][m + 2];
        west = new boolean[n + 2][m + 2];
        for (int x = 0; x < n + 2; x++) {
            for (int y = 0; y < m + 2; y++) {
                north[x][y] = true;
                east[x][y] = true;
                south[x][y] = true;
                west[x][y] = true;
            }
        }
    }

    // draw the maze
    public void draw() {
        north[1][m] = false; //start
        south[n][1] = false; //end

        for (int y = m; y >= 1; y--) {
            for (int x = 1; x <= n; x++) {
                System.out.print("+");
                if (north[x][y]) {
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("+");
            for (int x = 1; x <= n; x++) {
                if (x == 1) {
                    if (west[x][y]) {
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                }

                if (path[x][y] == -1)
                    System.out.print(" ");
                else if (path[x][y] == 10)
                    System.out.print("#");
                else
                    System.out.print(path[x][y]);

                if (east[x][y]) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

        for (int x = 1; x <= n; x++) {
            System.out.print("+");
            if (south[x][1]) {
                System.out.print("-");
            } else {
                System.out.print(" ");
            }
        }

        System.out.println("+");

    }

    public void draw0() {
        north[1][m] = false; //start
        south[n][1] = false; //end

        for (int y = m; y >= 1; y--) {
            for (int x = 1; x <= n; x++) {
                System.out.print("+");
                if (north[x][y]) {
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("+");
            for (int x = 1; x <= n; x++) {
                if (x == 1) {
                    if (west[x][y]) {
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                }

                if (bfsPath[x][y] == -1)
                    System.out.print(" ");
                else if (bfsPath[x][y] == 10)
                    System.out.print("#");
                else
                    System.out.print(bfsPath[x][y]);

                if (east[x][y]) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

        for (int x = 1; x <= n; x++) {
            System.out.print("+");
            if (south[x][1]) {
                System.out.print("-");
            } else {
                System.out.print(" ");
            }
        }

        System.out.println("+");

    }

    public static void main(String args[]) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        MazeGenerate mazeGenerate = new MazeGenerate(m, n);
        System.out.println("<pre>");
        mazeGenerate.draw();
        mazeGenerate.doit();
    }
}
