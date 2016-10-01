package com.terryx.gwu.algorithm;

import java.util.Arrays;

/**
 * @author taoranxue on 10/1/16 12:50 AM.
 */
public class RectangleOverlap {
    public boolean isOverlapped = false;

    public RectangleOverlap(Rectangle[] rectangles) {
        int n = rectangles.length;
        if (n <= 1) return;
        // check coincide
        Rectangle[] rectanglesByX = new Rectangle[n];
        System.arraycopy(rectangles, 0, rectanglesByX, 0, n);
        Arrays.sort(rectanglesByX, Rectangle.X_ORDER);
        for (int i = 0; i < n - 1; ++i) {
            if (rectanglesByX[i].equals(rectanglesByX[i + 1])) {
                isOverlapped = true;
                return;
            }
        }
        Rectangle[] rectanglesByY = new Rectangle[n];
        System.arraycopy(rectanglesByX, 0, rectanglesByY, 0, n);


        Rectangle[] aux = new Rectangle[n];
        overlapped(rectanglesByX, rectanglesByY, aux, 0, n - 1);
    }

    private void overlapped(Rectangle[] rectanglesByX, Rectangle[] rectanglesByY, Rectangle[] aux, int left, int right) {
        System.out.println("ok");
        if (left >= right) return;
        if (right - left <= 1) {
            // two rectangle
            System.out.println(rectanglesByY[left] + "; " + rectanglesByY[right]);
            if (rectanglesByY[left].rectangleOverlapping(rectanglesByY[right])) {
                isOverlapped = true;
                return;
            }
            int mid = left + (right - left) / 2;
            merge(rectanglesByY, aux, left, right, mid);
            return;
        }
        int mid = left + (right - left) / 2;
        merge(rectanglesByY, aux, left, right, mid);
        Point2D mediaCenter = rectanglesByX[mid].C();
        int m = 0;
        int left_right = left;
        int right_left = right;
        for (int i = left; i <= right; ++i) {
            if (rectanglesByY[i].rectangleToLine(mediaCenter) == 0) {
                aux[m++] = rectanglesByY[i];
            } else if (rectanglesByY[i].rectangleToLine(mediaCenter) < 0) {
                left_right = Math.max(left_right, i);
            } else {
                right_left = Math.min(right_left, i);
            }
        }
        System.out.println(m);
        for (int i = 0; i < m - 1; ++i) {
            System.out.println(rectanglesByY[i] + "; " + rectanglesByY[i+1]);
            if (rectanglesByY[i].rectangleYOverlapping(rectanglesByY[i + 1])) {
                isOverlapped = true;
                return;
            }
        }
        overlapped(rectanglesByX, rectanglesByY, aux, left, left_right);
        overlapped(rectanglesByX, rectanglesByY, aux, right_left, right);

    }

    private void merge(Rectangle[] a, Rectangle[] aux, int left, int right, int mid) {
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

    private boolean less(Rectangle a, Rectangle b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String args[]) {
        Rectangle[] rectangles = new Rectangle[]{
                new Rectangle(new Point2D(1, 1), new Point2D(2, 2)),
                new Rectangle(new Point2D(3, 3), new Point2D(4, 4)),
                new Rectangle(new Point2D(2, 3), new Point2D(5, 4)),
                new Rectangle(new Point2D(5, 5), new Point2D(6, 6))
        };
        RectangleOverlap rectangleOverlap = new RectangleOverlap(rectangles);
        System.out.println(rectangleOverlap.isOverlapped);
    }
}
