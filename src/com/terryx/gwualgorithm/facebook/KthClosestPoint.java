package com.terryx.gwualgorithm.facebook;

import com.terryx.main.Utils;
import java.util.*;

/**
 * @author taoranxue on 10/16/17 9:05 PM.
 */
public class KthClosestPoint {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
    /**
     * K max heap. Average(n log k)
     */
    public Point kthClosestPoint1(Point[] points, Point target, int k) {
        Queue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return dist(b, target) - dist(a, target);
            }
        });
        for (int i = 0; i < k; ++ i) {
            queue.offer(points[i]);
        }
        for (int i = k; i < points.length; ++ i) {
            if (dist(points[i], target) < dist(queue.peek(), target)) {
                queue.poll();
                queue.offer(points[i]);
            }
        }
        return queue.peek();
    }

    /**
     * Quick Select. Average O(n) Worst O(n^2)
     */
    public Point kthClosestPoint0(Point[] points, Point target, int k) {
        quickSelect(points, target, k - 1, 0, points.length - 1);
        return points[k - 1];
    }

    private void quickSelect(Point[] points, Point target, int k, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = partition(points, target, left, right);
        if (pivot == k) {
            return;
        }
        if (pivot < k) {
            quickSelect(points, target, k, pivot + 1, right);
        } else {
            quickSelect(points, target, k, left, pivot - 1);
        }
    }

    private int partition(Point[] points, Point target, int left, int right) {
        int pivot = right;
        int i = left, j = right - 1;
        int pivotVal = dist(target, points[pivot]);
        while (i <= j) {
            if (dist(points[i], target) < pivotVal) {
                i++;
            } else if (dist(points[j], target) >= pivotVal) {
                j--;
            } else {
                swap(points, i++, j--);
            }
        }
        swap(points, pivot, i);
        return i;
    }

    private int dist(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    private void swap(Point[] points, int i, int j) {
        Point tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;

    }

    public static void main(String[] args) {
        KthClosestPoint i = new KthClosestPoint();
        Point points[] = new Point[]{
                new Point(1, 2),
                new Point(3, 9),
                new Point(1, 1),
                new Point(6, 6),
                new Point(-1, -9)
        };
        System.out.println(
                i.kthClosestPoint1(points, new Point(0, 0), 2)
        );
    }
}
