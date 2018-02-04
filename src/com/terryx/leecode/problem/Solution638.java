package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/4/17 10:51 AM.
 */
public class Solution638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (price == null || price.size() == 0 || special == null || special.size() == 0 || needs == null || needs.size() == 0)
            return 0;
        return dfs(price, special, needs, new HashMap<List<Integer>, Integer>());

    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map) {
        if (map.containsKey(needs)) return map.get(needs);
        int res = 0;
        for (int i = 0; i < needs.size(); ++i) {
            res += (price.get(i) * needs.get(i));
        }
        for (List<Integer> offer : special) {
            List<Integer> tmp = new ArrayList<>(needs);
            int i = 0;
            for (; i < needs.size(); ++i) {
                int diff = needs.get(i) - offer.get(i);
                if (diff < 0) break;
                tmp.set(i, diff);
            }

            if (i == needs.size()) {
                res = Math.min(res, offer.get(i) + dfs(price, special, tmp, map));
            }
        }
        map.put(needs, res);
        return res;
    }
}
