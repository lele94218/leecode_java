package com.terryx.leecode.contest37;

import java.util.*;

/**
 * @author taoranxue on 6/17/17 10:07 PM.
 */
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        List<Integer> l = new ArrayList<>();
        for (Character c : map.keySet()) {
            l.add(map.get(c));
        }

        Collections.sort(l, Collections.reverseOrder());

        int f = 0;
        for (int i = 1; i < l.size(); ++ i) {
            if (l.get(i).equals(l.get(0))) {
                f++;
            }
            else break;
        }
        return Math.max(tasks.length, l.get(0) + (l.get(0) - 1) * n + f);
    }
}
