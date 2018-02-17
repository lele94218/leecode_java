package com.terryx.leecode.weeklycontest.contest52;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 2/16/18 6:57 PM.
 */
public class Solution689 {

    public int[] maxSumOfThreeSubarrays0(int[] nums, int K) {
        int W[] = new int[nums.length - K + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (i >= K) {
                sum -= nums[i - K];
            }
            if (i - K + 1 >= 0) {
                W[i - K + 1] = sum;
            }
        }

        int left[] = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; ++i) {
            if (W[i] > W[best]) {
                best = i;
            }
            left[i] = best;
        }

        int right[] = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; --i) {
            if (W[i] >= W[best]) {
                best = i;
            }
            right[i] = best;
        }
        int ans[] = new int[]{-1, -1, -1};
        for (int j = K; j < W.length - K; ++j) {
            int i = left[j - K], k = right[j + K];
            if (ans[0] == -1 || W[i] + W[j] + W[k] > W[ans[0]] + W[ans[1]] + W[ans[2]]) {
                ans[0] = i;
                ans[1] = j;
                ans[2] = k;
            }
        }
        return ans;
    }

    // k dp
    class Pair {
        int sum;
        List<Integer> list;

        Pair() {
            sum = 0;
            list = new ArrayList<>();
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sums[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        Pair dp[][] = new Pair[nums.length + 1][3];
        for (int i = k; i <= nums.length; ++i) {
            dp[i][0] = new Pair();
            if (i == k) {
                dp[i][0].sum = sums[i] - sums[i - k];
                dp[i][0].list.add(i - k);
            } else {
                if (sums[i] - sums[i - k] > dp[i - 1][0].sum) {
                    dp[i][0].sum = sums[i] - sums[i - k];
                    dp[i][0].list.add(i - k);
                } else {
                    dp[i][0].sum = dp[i - 1][0].sum;
                    dp[i][0].list.add(dp[i - 1][0].list.get(0));
                }
            }
            System.out.println(0 + ", " + i + ": " + dp[i][0].list + " sum: " + dp[i][0].sum);
        }

        for (int l = 1; l < 3; ++l) {
            //int choose = j - k >= 0 ? dp[i - 1][j - k] + sum[j] - sum[j - k] : 0;
            for (int i = k; i <= nums.length; ++i) {
                dp[i][l] = new Pair();
                int choose = dp[i - k][l - 1] != null ? dp[i - k][l - 1].sum + sums[i] - sums[i - k] : 0;
                System.out.println(choose);
                if (i - 1 >= k) {
                    dp[i][l].sum = dp[i - 1][l].sum;
                    dp[i][l].list = new ArrayList<>(dp[i - 1][l].list);
                }
                if (choose > dp[i][l].sum) {
                    dp[i][l].sum = choose;
                    dp[i][l].list = new ArrayList<>(dp[i - k][l - 1].list);
                    dp[i][l].list.add(i - k);
                }
                System.out.println(l + ", " + i + ": " + dp[i][l].list + " sum: " + dp[i][l].sum);
            }
        }

        int ans[] = new int[3];
        for (int i = 0; i < 3; ++i) {
            ans[i] = dp[nums.length][2].list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution689 m = new Solution689();
//        System.out.println(Utils.debug(m.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
        System.out.println(Utils.debug(m.maxSumOfThreeSubarrays(new int[]{7, 13, 20, 19, 19, 2, 10, 1, 1, 19}, 3)));
    }
}
