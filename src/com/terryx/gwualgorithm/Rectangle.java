package com.terryx.gwualgorithm;

import java.util.Comparator;

/**
 * @author taoranxue on 10/1/16 12:56 AM.
 */
public class Rectangle implements Comparable<Rectangle> {
    private final Point2D rightUp;
    private final Point2D leftDown;
    private final Point2D center;

    public static final Comparator<Rectangle> X_ORDER = new CenterOder();

    public Rectangle(Point2D leftDown, Point2D rightUp) {
        this.rightUp = rightUp;
        this.leftDown = leftDown;
        this.center = new Point2D((rightUp.x() + leftDown.x()) / 2.0, (rightUp.y() + leftDown.y()) / 2.0);
    }

    public Point2D rUp() {
        return this.rightUp;
    }

    public Point2D lDn() {
        return this.leftDown;
    }

    public Point2D C() {
        return this.center;
    }

    public int rectangleToLine(Point2D p) {
        if (this.rUp().x() < p.x()) return -1;
        if (this.lDn().x() > p.x()) return 1;
        return 0;
    }

    public boolean rectangleYOverlapping(Rectangle other) {
        if (this.rUp().y() >= other.lDn().y() || other.rUp().y() >= this.lDn().y()) return true;
        return false;
    }

    public boolean rectangleOverlapping(Rectangle other) {
        if (this.rUp().x() < other.lDn().x() || other.rUp().x() < this.lDn().x()) return false;
        if (this.lDn().y() > other.rUp().y() || other.lDn().y() > this.rUp().y()) return false;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return this.lDn().equals(rectangle.lDn()) && this.rUp().equals(rectangle.rUp());
    }

    @Override
    public int compareTo(Rectangle other) {
        return this.leftDown.compareTo(other.leftDown);
    }

    private static class CenterOder implements Comparator<Rectangle> {
        @Override
        public int compare(Rectangle p, Rectangle q) {
            return Point2D.X_ORDER.compare(p.C(), q.C());
        }
    }

    @Override
    public String toString() {
        return this.lDn().toString() + " " + this.rUp().toString();
    }
}
