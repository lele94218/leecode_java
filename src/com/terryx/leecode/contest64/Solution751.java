package com.terryx.leecode.contest64;

import java.util.*;

/**
 * @author taoranxue on 1/16/18 1:57 PM.
 */
public class Solution751 {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> res = new ArrayList<>();
        if (ip == null) {
            return res;
        }
        long start = ipToLong(ip);
        while (n > 0) {
            int mask = Math.max(33 - bitLength(Long.lowestOneBit(start)), 33 - bitLength(n));
            res.add(longToIp(start) + "/" + mask);
            start += (1 << (32 - mask));
            n -= (1 << (32 - mask));
        }
        return res;
    }

    private long ipToLong(String ip) {
        String[] strs = ip.split("\\.");
        long res = 0;
        for (String num : strs) {
            res = res * 256 + Integer.parseInt(num);
        }
        return res;
    }

    private String longToIp(long num) {
        return String.format("%d.%d.%d.%d", (num >> 24) % 256, (num >> 16) % 256, (num >> 8) % 256, num % 256);
    }

    private int bitLength(long n) {
        if (n == 0) {
            return 1;
        }
        int res = 0;
        while (n > 0) {
            n >>= 1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution751 m = new Solution751();
        System.out.println(m.ipToCIDR("255.0.0.7", 10));
    }
}
