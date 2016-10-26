package com.terryx.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taoranxue on 10/25/16 9:13 PM.
 */
public class Solution17 {
    List<String> res = new ArrayList<>();
    final Map<Integer, char[]> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        map.put(1, new char[]{});
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
        map.put(0, new char[]{' '});
        map.put(10, new char[]{'*'});//*
        map.put(11, new char[]{'#'});//#
        dfs(digits, 0, new ArrayList<>());
        return res;

    }

    private void dfs(String digits, int index, List<Character> tmp) {
        if (index >= digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : tmp) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }
        int c = digits.charAt(index) - '0';
        for (int j = 0; j < map.get(c).length; ++ j) {
            tmp.add(map.get(c)[j]);
            dfs(digits, index + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
