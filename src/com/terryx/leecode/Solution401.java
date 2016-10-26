package com.terryx.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 10/25/16 8:41 PM.
 */
public class Solution401 {
    List<String> res = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        dfs(num, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int depth, List<Integer> tmp) {
        if (n == 0) {
            int hour = 0;
            for (int i = 0; i < 4; ++ i) {
                hour <<= 1;
                if (i < tmp.size() && tmp.get(i) == 1) {
                    hour += 1;
                }
            }
            int minute = 0;
            for (int i = 4; i < 10; ++ i) {
                minute <<= 1;
                if (i < tmp.size() && tmp.get(i) == 1) {
                    minute += 1;
                }
            }
            if (hour > 11 || minute > 59) return;
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":");
            sb.append(String.format("%02d", minute));
            res.add(sb.toString());
            return;
        } else if (depth >= 10) return;
        tmp.add(1);
        dfs(n - 1, depth + 1,tmp);
        tmp.remove(tmp.size() - 1);
        tmp.add(0);
        dfs(n, depth + 1, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
