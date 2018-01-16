package com.terryx.leecode.contest64;

import java.util.*;

/**
 * @author taoranxue on 1/15/18 11:23 PM.
 */
public class Solution753 {
    public String crackSafe(int n, int k) {
        int total = (int) Math.pow(k, n);
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append("0");
        }
        queue.offer(sb.toString());
        set.add(sb.toString());
        if (set.size() == total) {
            return sb.toString();
        }
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            String tmp = cur.substring(cur.length() - n + 1, cur.length());
            boolean flag = false;
            for (int i = k - 1; i >= 0; --i) {
                String a = tmp + (char) ('0' + i);
                if (!set.contains(a)) {
                    queue.offer(cur + (char) ('0' + i));
                    set.add(a);

                    if (set.size() == total) {
                        return cur + (char) ('0' + i);
                    }

                    flag = true;
                    break;
                }
            }



            if (flag) {
                continue;
            }


            for (int i = k - 1; i >= 0; --i) {
                queue.offer(cur + (char) ('0' + i));
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution753 m = new Solution753();
        System.out.println(m.crackSafe(1,4));
    }
}
