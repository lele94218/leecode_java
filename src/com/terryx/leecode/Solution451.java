package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/19/17 11:50 AM.
 */
public class Solution451 {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            Character c = s.charAt(i);
            Integer v = map.get(c);
            if (v != null) {
                map.put(c, v + 1);
            } else {
                map.put(c, 1);
            }
        }

        List<Character>[] bucket = new List[s.length() + 1];

        for (Character c : map.keySet()) {
            Integer v = map.get(c);
            if (bucket[v] == null) {
                bucket[v] = new ArrayList<Character>();
            }
            bucket[v].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; --i) {
            if (bucket[i] != null) {
                // System.out.println(i);
                for (Character c : bucket[i]) {
                    for (int j = 0; j < map.get(c); ++j) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
