package com.terryx.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taoranxue on 10/8/16 6:23 PM.
 */
public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }

        List<Integer> [] bucket = new List[nums.length + 1];

        for (int key : hm.keySet()) {
            int frequency = hm.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; -- i) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res.subList(0, k);
    }
}
