package com.terryx.interview.google;

/**
 * @author taoranxue on 6/14/17 7:48 PM.
 */
public class FindtheAccessCodes {
    public static int answer(int[] l) {

        // Your code goes here.
//        Arrays.sort(l);
        int dp[] = new int[l.length + 1];
        dp[0] = 0;
        int res = 0;
        for (int i = 0; i < l.length; ++i) {
            int cnt = 0;
            for (int j = i + 1; j < l.length; ++j) {
                if (l[j] % l[i] == 0) {
                    dp[j]++;
                    cnt++;
                }
            }
            res += dp[i] * cnt;
        }
        return res;

    }

    public static void main(String args[]) {
        System.out.println(answer(new int[]{2, 2, 2, 2, 4, 4, 5, 6, 8, 8, 8}));
    }

}
