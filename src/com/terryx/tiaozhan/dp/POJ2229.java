package com.terryx.tiaozhan.dp;

import java.util.*;

/**
 * @author taoranxue on 1/15/18 6:18 PM.
 */
public class POJ2229 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= sum; ++ i) {
            if (i % 2 == 0) {
                dp[i] = (int)(((long)dp[i - 1] + dp[i / 2]) % 1000000000L);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(dp[sum]);
    }
}
