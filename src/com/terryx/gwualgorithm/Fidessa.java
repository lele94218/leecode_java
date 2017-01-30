package com.terryx.gwualgorithm;

import java.util.Scanner;

/**
 * @author taoranxue on 1/26/17 2:40 PM.
 */
public class Fidessa {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int line[] = new int[10];
        int t = 0;
        t = scan.nextInt();
        while (t-- > 0) {
            for (int i = 0; i < 3; ++i) {
                line[i] = scan.nextInt();
            }

            boolean flag = false;
            if (line[0] + line[1] > line[2] &&
                    line[0] + line[2] > line[1] &&
                    line[1] + line[2] > line[0]) {
                flag = true;
            }

            if (!flag) {
                System.out.println("None of these");
            } else {
                if (line[0] == line[1] && line[0] == line[2]) {
                    System.out.println("Equilateral");
                } else if (line[0] != line[1] && line[0] != line[2] && line[1] != line[2]) {
                    System.out.println("None of these");
                } else {
                    System.out.println("Isosceles");
                }
            }

        }
    }
}
