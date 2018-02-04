package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taoranxue on 8/13/17 8:12 PM.
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>(0);
        // Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
//         for (String word : strs) {
//             char s[] = word.toCharArray();
//             Arrays.sort(s);
//             String ts = String.valueOf(s);
//             if (map.get(ts) == null) {
//                 map.put(ts, new ArrayList<String>());
//             }
//             map.get(ts).add(word);
//         }

//         for (String key : map.keySet()) {
//             res.add(map.get(key));
//         }

//         return res;

        // Another quick algorithm

        Map<Integer, List<String>> map = new HashMap<>();
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for (String word : strs) {
            int key = 1;
            for (int i = 0; i < word.length(); ++i) {
                key *= prime[word.charAt(i) - 'a'];
            }
            if (map.get(key) == null) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
        }

        for (Integer key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;

    }
}
