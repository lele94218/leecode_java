package com.terryx.leecode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author taoranxue on 10/9/16 8:35 PM.
 */
public class Solution373 {
    private class Pair {
        int num1;
        int num2;
        int index;
        int sum;
        public Pair(int num1, int num2, int index) {
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
            this.index = index;
        }
        public int[] toArray() {
            return new int[]{num1, num2};
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return res;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p, Pair q) {
                return (p.sum - q.sum);
            }
        });
        for (int i = 0; i < k && i < nums1.length; ++ i) {
           pq.offer(new Pair(nums1[i], nums2[0], 0));
        }
        int cnt = 0;

        while (!pq.isEmpty() && cnt < k) {
            Pair temp = pq.poll();
            cnt ++;
            res.add(temp.toArray());
            int index = temp.index + 1;
            if (index < nums2.length) pq.offer(new Pair(temp.num1, nums2[index], index));
        }

        return res;
    }
}
