package com.terryx.gwualgorithm;

import java.util.Random;

/**
 * @author taoranxue on 9/26/16 2:58 AM.
 */
public class RandomData {
    public static Point2D[] randomPoint2D(int n) {
        Point2D[] points = new Point2D[n];
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            points[i] = new Point2D(x, y);
        }
        return points;
    }
}
