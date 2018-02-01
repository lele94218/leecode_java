package com.terryx.interview.facebook;

/**
 * @author taoranxue on 10/16/17 8:21 PM.
 */
public class Fibonacci {
    public int getPisanoPeriod(int n, int m) {
        int a = 0, b = 1, c = a + b;
        int i = 0;
        for (; i < n; i++) {
            c = (a+b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) return i+1;
        }
        return i;
    }

    public int getFibonacciModN(int n, int m) {
        int remainder = n % getPisanoPeriod(n, m);
        int first = 0, second = 1;
        int res = remainder;
        for (int i = 0; i < remainder-1; i++) {
            res = (first + second) % m;
            first = second;
            second = res;
        }
        return res % m;
    }
    public static void main(String[] args) {
        int a = 1, b = 1;
        for (int i = 0; i < 30; i++) {
            int res = a + b;
            System.out.println(res);
            a = b;
            b = res;
        }

    }
}
