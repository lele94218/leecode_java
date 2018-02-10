package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 12/10/16 8:13 PM.
 */
public class Solution249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            int shift = (str.charAt(0) - 'a' + 26) % 26;
            sb.append('a');
            for (int i = 1; i < str.length(); ++i) {
                sb.append((char) ((str.charAt(i) - shift + 26) % 26));
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(str);
        }
        for (String str : map.keySet()) {
            res.add(map.get(str));
        }
        return res;
    }
}
