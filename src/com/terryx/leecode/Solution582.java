package com.terryx.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author taoranxue on 6/12/17 6:40 PM.
 */
public class Solution582 {

    HashMap<Integer, List<Integer>> map = new HashMap<>();

    List<Integer> res = new ArrayList<>();
    void kill(int pid) {
        res.add(pid);
        if (!map.containsKey(pid)) return;
        for (Integer child : map.get(pid)) {
            kill(child);
        }
    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        for (int i = 0; i < pid.size(); ++ i) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            if (map.containsKey(parent)) {
                map.get(parent).add(child);
            } else {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(child);
                map.put(parent, tmpList);
            }
        }
        return res;
    }
}
