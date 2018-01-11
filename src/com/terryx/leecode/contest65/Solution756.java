package com.terryx.leecode.contest65;

import java.util.*;

/**
 * @author taoranxue on 1/10/18 6:05 PM.
 */
public class Solution756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom == null || bottom.length() == 0 || allowed == null || allowed.size() == 0) {
            return false;
        }
        Set<String> pyramid[] = new Set[bottom.length()];
        for (int i = 0; i < bottom.length(); ++i) {
            pyramid[i] = new HashSet<String>();
            pyramid[i].add(bottom.charAt(i) + "");
        }

        HashMap<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < allowed.size(); ++i) {
            String key = allowed.get(i).substring(0, 2);
            if (!map.containsKey(key)) {
                map.put(key, new HashSet<>());
            }
            map.get(key).add(allowed.get(i).substring(2, 3));
        }

        for (int i = bottom.length(); i >= 2; --i) {
            for (int j = 0; j < i - 1; ++j) {
                Set<String> l0 = new HashSet<>(pyramid[j]);
                Set<String> l1 = new HashSet<>(pyramid[j + 1]);
                pyramid[j].clear();
                for (String s0 : l0) {
                    for (String s1 : l1) {
                        String key = s0 + s1;
                        Set<String> value = map.get(key);
                        if (value != null) {
                            pyramid[j].addAll(value);
                        }
                    }
                }
                if (pyramid[j].size() == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
