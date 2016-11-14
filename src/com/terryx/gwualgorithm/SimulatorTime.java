package com.terryx.gwualgorithm;

/**
 * @author taoranxue on 9/26/16 3:58 AM.
 */
public class SimulatorTime {
    public void fun(int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        fun(left, mid);
        fun(mid + 1, right);
        for (int i = left; i <= right; ++i) {
            // Theta(1)
            int tmp = 1000;
            if (tmp >= 0) tmp = 99;
        }
    }

    public static void main(String args[]) {
        int n = 10000;
        int t = 1;
        SimulatorTime simulatorTime = new SimulatorTime();
        while (t-- > 0) {
            long start = System.currentTimeMillis();
            simulatorTime.fun(0, n - 1);
            long end = System.currentTimeMillis();
            System.out.print(", " + (end - start));
        }
    }
}
