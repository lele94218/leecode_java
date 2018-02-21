package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/21/18 4:01 PM.
 */
public class Solution244 {
    class WordDistance {
        Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                if (!map.containsKey(word)) {
                    map.put(word, new ArrayList<>());
                }
                map.get(word).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> l1 = map.get(word1), l2 = map.get(word2);
            int res = Integer.MAX_VALUE, i = 0, j = 0;
            while (i < l1.size() && j < l2.size()) {
                res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
                if (l1.get(i) < l2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }
}
