package com.terryx.interview.purestorage;

/**
 * @author taoranxue on 11/2/17 2:54 AM.
 */
public class DrawCircle {
    //naive way
    public static void drawCircle0(int x0, int y0, int r) {
        int x = 0, y = r;
        while (x < y) {
            double midX = x + 1.0, midY = y - 0.5;
            double d = (midX + 0.0f) * (midX + 0.0f) + (midY + 0.0f) * (midY + 0.0f) - r * r;
            //System.out.println(d);
            if (d < 0.0) {
                x += 1;
            } else {
                x += 1;
                y -= 1;
            }
            System.out.println((x + x0) + " " + (y + y0));
        }
    }

    public static void drawCircle1(int x0, int y0, int r) {
        int x = 0, y = r, d = 1 - r;
        while (x < y) {
            if (d < 0) {
                d += (x << 1) + 3;
                x += 1;
            } else {
                d += (x << 1) - (y << 1) + 5;
                x += 1;
                y -= 1;
            }
            System.out.println((x + x0) + " " + (y + y0));
        }
    }

    public static void main(String[] args) {
        drawCircle0(0, 0, 10);
        System.out.println("----------");
        drawCircle1(0, 0, 10);
    }
}
