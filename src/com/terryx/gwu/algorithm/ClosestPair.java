package com.terryx.gwu.algorithm;

import java.util.Arrays;

/**
 * @author taoranxue on 9/25/16 11:44 PM.
 */
public class ClosestPair {
    private double bestDistance = Double.POSITIVE_INFINITY;
    private int cnt = 0;

    public static double bruteForce(Point2D[] points) {
        int n = points.length;
        double resDistance = Double.POSITIVE_INFINITY;
        for (int i = 0; i < n; ++ i) {
            for (int j = i + 1; j < n; ++ j) {
                resDistance = Math.min(points[i].distanceTo(points[j]), resDistance);
            }
        }
        return resDistance;
    }

    public ClosestPair(Point2D[] points) {
        int n = points.length;
        if (n <= 1) return;
        Point2D[] pointsByX = new Point2D[n];
        System.arraycopy(points, 0, pointsByX, 0, n);
        Arrays.sort(pointsByX, Point2D.X_ORDER);
        // check coincide
        for (int i = 0; i < n - 1; ++i) {
            if (pointsByX[i].equals(pointsByX[i + 1])) {
                System.out.println("error dara");
                bestDistance = 0.0;
                return;
            }
        }
        Point2D[] pointsByY = new Point2D[n];
        System.arraycopy(pointsByX, 0, pointsByY, 0, n);

//        for (Point2D point : pointsByY) {
//            System.out.print(point + " ");
//        }
//        System.out.println();

        Point2D[] aux = new Point2D[n];
        closest(pointsByX, pointsByY, aux, 0, n - 1);

    }

    public double closest(Point2D[] pointsByX, Point2D[] pointsByY, Point2D[] aux, int left, int right) {
//        System.out.println(left + " " + right);
        if (left >= right) return Double.POSITIVE_INFINITY;
        int mid = left + (right - left) / 2;
        Point2D median = pointsByX[mid];

        double delta1 = closest(pointsByX, pointsByY, aux, left, mid);
        double delta2 = closest(pointsByX, pointsByY, aux, mid + 1, right);
        double delta = Math.max(delta1, delta2);

        //sort pointsByY
        merge(pointsByY, aux, left, right, mid);
//        System.out.println("back: " + left + " " + right);
//        for (Point2D point : pointsByY) {
//            System.out.print(point + " ");
//        }
//        System.out.println();
        int m = 0;
        for (int i = left; i <= right; ++i) {
            if (Math.abs(pointsByY[i].x() - median.x()) < delta)
                aux[m++] = pointsByY[i];
        }
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m && (aux[j].y() - aux[i].y() < delta); ++j) {
                cnt++;
                double distance = aux[i].distanceTo(aux[j]);
//                System.out.println(distance);
                if (distance < delta) {
                    delta = distance;
                    if (distance < bestDistance) {
                        bestDistance = distance;
                    }
                }
            }
        }
        return delta;
    }

    public static void merge(Comparable[] a, Comparable[] aux, int left, int right, int mid) {
        System.arraycopy(a, left, aux, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; ++k) {
            if (i > mid) a[k] = aux[j++];
            else if (j > right) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
//        int n = scanner.nextInt();
        int n = 5000;
        int t = 100;
        while (t-- > 0) {
            Point2D[] points = RandomData.randomPoint2D(n);
            long start = System.currentTimeMillis();
            ClosestPair closestPair = new ClosestPair(points);
            long end = System.currentTimeMillis();
            System.out.print(n + ", " + (end - start) + ", ");


            start = System.currentTimeMillis();
            bruteForce(points);
            end = System.currentTimeMillis();

            System.out.println((end - start));
            n += 5000;

        }
    }

}
