package com.terryx.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taoranxue on 8/17/17 3:00 PM.
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) return new ArrayList<String>(0);
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 10; j <= s.length(); ++ i, ++ j) {
            String cur = s.substring(i, j);
            Integer val = map.get(cur);
            if (val != null && val == 1) {
                res.add(cur);
                map.put(cur, 2);
            } else if (val == null) {
                map.put(cur, 1);
            }
        }
        return res;
    }
}
