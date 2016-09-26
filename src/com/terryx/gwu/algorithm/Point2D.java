package com.terryx.gwu.algorithm;

import java.util.Comparator;

/**
 * @author taoranxue on 9/25/16 11:44 PM.
 */
public final class Point2D implements Comparable<Point2D> {
    private final double x;
    private final double y;

    public static final Comparator<Point2D> X_ORDER = new XOder();

    public Point2D(double x, double y) {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0) this.x = 0.0;  // convert -0.0 to +0.0
        else this.x = x;

        if (y == 0.0) this.y = 0.0;  // convert -0.0 to +0.0
        else this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    private static class XOder implements Comparator<Point2D> {
        @Override
        public int compare(Point2D p, Point2D q) {
            if (p.x < q.x) return -1;
            if (p.x > q.x) return +1;
            return 0;
        }
    }

    public double distanceTo(Point2D that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Point2D point2D = (Point2D) obj;
        return this.x == point2D.x && this.y == point2D.y;
    }

    @Override
    public int compareTo(Point2D that) {
        if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return +1;
        return 0;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
