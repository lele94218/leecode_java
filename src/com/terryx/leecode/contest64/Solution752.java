package com.terryx.leecode.contest64;

import java.util.*;

/**
 * @author taoranxue on 1/15/18 10:57 PM.
 */
public class Solution752 {
    public int openLock(String[] deadends, String target) {
        if (deadends == null || deadends.length == 0 || target == null) {
            return -1;
        }
        Set<String> set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> vist = new HashSet<>();
        queue.offer("0000");
        vist.add("0000");
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                String cur = queue.poll();
                //System.out.println(cur);
                if (set.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return level;
                }
                for (int j = 0; j < 4; ++j) {
                    char[] chars = cur.toCharArray();
                    int slot = chars[j] - '0';
                    int up = (slot + 1) % 10, down = (slot - 1 + 10) % 10;
                    chars[j] = (char) ('0' + up);
                    String next0 = new String(chars);
                    if (!vist.contains(next0)) {
                        vist.add(next0);
                        queue.offer(next0);
                    }
                    chars[j] = (char) ('0' + down);
                    String next1 = new String(chars);
                    if (!vist.contains(next1)) {
                        vist.add(next1);
                        queue.offer(next1);
                    }
                }
            }

            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution752 m = new Solution752();
        System.out.println(m.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(m.openLock(new String[]{"8888"}, "0009"));
        System.out.println(m.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
        System.out.println(m.openLock(new String[]{"0000"}, "8888"));
    }
}
