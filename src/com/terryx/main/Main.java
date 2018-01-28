package com.terryx.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    public int getMinDrops(int B, int M) {
        //write your solution here
        int dp[][] = new int[M + 1][B + 1];
        for (int i = 1; i <= M; i++) {
            dp[i][1] = i - 1;
        }
        for (int i = 1; i <= B; i++) {
            dp[1][i] = 0;
        }
        for (int i = 2; i <= M; i++) {
            for (int j = 2; j <= B; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], dp[i - k][j]));
                }
                dp[i][j] += 1;

            }
        }
        return dp[M][B];
    }


    /**
     * 1,3,2 -> 2,1,3
     * 9,2,2 -> 2,2,9
     * 1,3,1,2,4,7 -> 1,3,1,2,7,4
     */
    public String getNextPermutation(String input) {

        if (input == null) return "";
        char nums[] = input.toCharArray();
        int index = -1;
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
                break;
            }
        }


        if (index == -1) {
            return "BIGGEST";
        }


        int biggerIdx = nums.length - 1;
        for (int i = nums.length - 1; i > index + 1; --i) {
            if (nums[i - 1] > nums[index] && nums[index] >= nums[i]) {
                biggerIdx = i - 1;
                break;
            }
        }
        swap(nums, biggerIdx, index);
        reverse(nums, index + 1, nums.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private void swap(char nums[], int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(char nums[], int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public int getAdjBCStringCount(int n, int k) {
        //write your solution here
        int dp[][][] = new int[n + 1][k + 1][2];
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                if (j > 0) {
                    dp[i][j][1] = dp[i - 1][j - 1][1];
                }
                dp[i][j][1] += dp[i - 1][j][0];

            }
        }
        return dp[n][k][0] + dp[n][k][1];
    }

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
//        System.out.println(m.getMinDrops(2, 10));
//        System.out.println(m.getMinDrops(2, 100));
//        System.out.println(m.getMinDrops(2, 300));
//        System.out.println(m.getMinDrops(25, 900));
//        System.out.println(m.getMinDrops(15, 368));
//        System.out.println(m.getMinDrops(15, 100));
//        System.out.println(m.getMinDrops(41, 782));
//        System.out.println(m.getNextPermutation("279134399742"));
//        System.out.println(m.getNextPermutation("1987654321"));
//        System.out.println(m.getNextPermutation("987"));
        System.out.println(Integer.MAX_VALUE);

    }


}
