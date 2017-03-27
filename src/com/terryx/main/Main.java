package com.terryx.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main implements Cloneable {
    public static void main(String args[]) {
        int n = 5;
        double m[][] = new double[][]{
                new double[]{1, 2, 3, 4, 5},
                new double[]{1, 2, 3, 4, 5},
                new double[]{1, 2, 3, 4, 5},
                new double[]{1, 2, 3, 4, 5},
                new double[]{1, 2, 3, 4, 5}
        };
        String map[] = new String[]{
                "Zero",
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
        };
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                String tmp = Double.toString(m[i][j]);
                for (int ix = 0; ix < tmp.length(); ++ix) {
                    if (tmp.charAt(ix) == '.') System.out.print("Del");
                    else System.out.print(map[tmp.charAt(ix) - '0']);
                }
                System.out.print(" ");
            }
            System.out.println();
        }

    }


}
