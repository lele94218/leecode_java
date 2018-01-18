package com.terryx.tiaozhan.dp;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 1/16/18 2:48 PM.
 */
public class POJ1742 {
    public static void main(String[] args) {
        int n, m;
        int a[] = new int[110], c[] = new int[110], dp[] = new int[1000010];
        Scanner in = new Scanner(System.in);
        while (true) {
            n = in.nextInt();
            m = in.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; ++i) {
                c[i] = in.nextInt();
            }
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j <= m; ++j) {
                    if (dp[j] >= 0) {
                        dp[j] = c[i];
                    } else if (j >= a[i] && dp[j - a[i]] > 0) {
                        dp[j] = dp[j - a[i]] - 1;
                    }
                }
            }
            int res = 0;
            for (int i = 1; i <= m; ++i) {
                if (dp[i] > -1) {
                    res++;
                }
            }

            System.out.println(res);
        }
    }
}
