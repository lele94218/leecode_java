package com.terryx.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taoranxue on 9/26/16 5:44 PM.
 */
public class Solution241 {
    private Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                System.out.println(left + " " + right);
                List<Integer> leftList = map.getOrDefault(left, diffWaysToCompute(left));
                List<Integer> rightList = map.getOrDefault(right, diffWaysToCompute(right));
                for (Integer lInt : leftList) {
                    for (Integer rInt : rightList) {
                        System.out.format("%d%c%d\n", lInt, c, rInt);
                        int r = 0;
                        if (c == '+') {
                            r = lInt + rInt;
                        } else if (c == '-') {
                            r = lInt - rInt;
                        } else {
                            r = lInt * rInt;
                        }
                        res.add(r);
                    }
                }
            }
        }
        if (res.size() <= 0) {
            res.add(Integer.parseInt(input));
        }
        map.put(input, res);

        return res;
    }
}
