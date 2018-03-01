package com.terryx.leecode.weeklycontest.contest72;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 2/20/18 11:57 PM.
 */
public class Solution786 {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int N = A.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int s1 = A[a[0]] * A[N - b[1] - 1];
                int s2 = A[b[0]] * A[N - a[1] - 1];
                return s1 - s2;
            }
        });
        for (int i = 0; i < N; ++i) {
            queue.offer(new int[]{i, 0});
        }
        for (int i = 0; i < K; ++i) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (i == K - 1) {
                return new int[]{A[x], A[N - y - 1]};
            }
            if (x + y + 1 < N) {
                cur[1]++;
                queue.offer(cur);
            }
        }
        return null;
    }

    // Binary Search very fast
    public int[] kthSmallestPrimeFraction0(int[] A, int K) {
        int n = A.length;
        double low = (double) A[0] / A[n - 1];
        double high = (double) A[n - 1] / A[0];
        Set<Integer> set = new HashSet<>();
        for (int a : A) set.add(a);
        for (int itr = 0; itr < 100; ++itr) {
            double mid = (low + high) * 0.5;
            int i = 0, j = 0, cnt = 0;
            for (; i < n; ++i) {
                for (; j < n; ++j) {
                    if (i < j && A[i] < mid * A[j]) {
                        cnt += (n - j);
                        break;
                    }
                }
            }
            if (cnt < K) {
                low = mid;
            } else {
                high = mid;
            }
        }
        for (int a : A) {
            double p = Math.round(low * (double) a);
            if (Math.abs(p - low * (double) a) < 1e-5 && set.contains((int) p)) {
                return new int[]{(int) p, a};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution786 m = new Solution786();
        System.out.println(Utils.debug(m.kthSmallestPrimeFraction(new int[]{1, 7, 23, 29, 47}, 8)));
    }
}
