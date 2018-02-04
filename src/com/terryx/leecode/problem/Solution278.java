package com.terryx.leecode.problem;

/**
 * @author xueta on 8/24/2016 7:08 PM.
 *         You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest
 *         version of your product fails the quality check. Since each version is developed based on the previous version,
 *         all the versions after a bad version are also bad.
 *         <p>
 *         Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
 *         following ones to be bad.
 *         <p>
 *         You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function
 *         to find the first bad version. You should minimize the number of calls to the API.
 */
public class Solution278 {
    private static boolean isBadVersion(int version) {
        return version != 1;
    }

    public static int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
//            int mid = (l + r) >> 1;
            if (!isBadVersion(mid)) {
                if (l == mid) {
                    l = mid + 1;
                } else l = mid;
            } else {
                if (r == mid) {
                    r = mid - 1;
                } else r = mid;
            }
        }
        return r;
    }
}
