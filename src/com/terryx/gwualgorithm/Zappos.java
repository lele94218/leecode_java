package com.terryx.gwualgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author taoranxue on 1/29/17 4:05 PM.
 */
public class Zappos {
    static boolean GigawattPower(int[] batteryOne, int[] batteryTwo, int gigawattTarget) {
        Map<Integer, Integer> map = new HashMap<>();
        if (batteryOne.length > batteryTwo.length) {
            int[] _tmp = batteryOne;
            batteryOne = batteryTwo;
            batteryTwo = _tmp;
        }
        for (int i = 0; i < batteryTwo.length; ++i) {
            map.put(batteryTwo[i], i);
        }

        boolean res = false;
        for (int i = 0; i < batteryOne.length; ++i) {
            int comp = gigawattTarget - batteryOne[i];
            if (map.containsKey(comp)) {
                res = true;
                break;
            }
        }
        return res;
    }

    static String improbabilityCalculator(String coordinates, int remove) {
        if (coordinates == null || coordinates.length() == 0 || remove >= coordinates.length()) return "0";
        if (remove == 0) return coordinates;

        Stack<Character> stack = new Stack<>();
        int ix = 0;
        while (ix < coordinates.length()) {
            while (remove > 0 && !stack.isEmpty() && stack.peek() > coordinates.charAt(ix)) {
                stack.pop();
                remove--;
            }
            stack.push(coordinates.charAt(ix));
            ix++;
        }

        while (remove > 0) {
            stack.pop();
            remove--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        return sb.toString();
    }

    static int numberOfGroups(int[][] venue) {

        int n = venue.length;

        if (n == 0) return 0;
        int m = venue[0].length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (venue[i][j] == 1) {
                    dfs(venue, i, j, n, m);
                    ++count;
                }
            }
        }
        return count;
    }

    static void dfs(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1) return;
        grid[i][j] = 0;
        dfs(grid, i + 1, j, n, m);
        dfs(grid, i - 1, j, n, m);
        dfs(grid, i, j + 1, n, m);
        dfs(grid, i, j - 1, n, m);
        //
        dfs(grid, i - 1, j + 1, n, m);
        dfs(grid, i + 1, j + 1, n, m);
        dfs(grid, i - 1, j - 1, n, m);
        dfs(grid, i + 1, j - 1, n, m);
    }

    static String reverseButPreserveWhitespace(String reverseMe) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < reverseMe.length(); ++i) {
            if (reverseMe.charAt(i) == ' ') {
                if (sb.length() > 0) {
                    res.append(sb.reverse());
                    sb.setLength(0);
                }
                res.append(reverseMe.charAt(i));
            } else {
                sb.append(reverseMe.charAt(i));
            }
        }

        //
        if (sb.length() > 0) {
            res.append(sb.reverse());
            sb.setLength(0);
        }

        return res.toString();
    }

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static double sign(Point p1, Point p2, Point p3) {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    static boolean inTriangle(Point pt, Point v1, Point v2, Point v3) {
        boolean b1, b2, b3;

        b1 = sign(pt, v1, v2) < 0.0f;
        b2 = sign(pt, v2, v3) < 0.0f;
        b3 = sign(pt, v3, v1) < 0.0f;

        return ((b1 == b2) && (b2 == b3));

    }

    static int foundInBermudatriangle(int x1, int y1, int x2, int y2, int x3, int y3, int px, int py, int bx, int by) {
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        Point c = new Point(x3, y3);
        Point plane = new Point(px, py);
        Point boat = new Point(bx, by);

        double ab = distance(a, b);
        double ac = distance(a, c);
        double bc = distance(b, c);

        if (!(ab + ac > bc && ab + bc > ac && ac + bc > ab)) {
            return 0;
        }

        if (inTriangle(plane, a, b, c) && !inTriangle(boat, a, b, c)) return 1;
        if (!inTriangle(plane, a, b, c) && inTriangle(boat, a, b, c)) return 2;
        if (inTriangle(plane, a, b, c) && inTriangle(boat, a, b, c)) return 3;
        if (!inTriangle(plane, a, b, c) && !inTriangle(boat, a, b, c)) return 4;

        return -1;
    }


    public static void main(String args[]) {
        System.out.println(reverseButPreserveWhitespace("  fdsfasd  dfsafds  fdsafsd. fds  "));
    }
}
