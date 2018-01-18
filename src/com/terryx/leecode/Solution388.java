package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 2:36 PM.
 */
public class Solution388 {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Deque<String> queue = new ArrayDeque<>();
        String strs[] = input.split("\\n");
        int res = 1, cur = 0, lastTab = -1;
        for (String name : strs) {
            int tab = 0, index = 0, start = 0;
            while (index < name.length() && (index = name.indexOf("\t", index)) != -1) {
                tab++;
                start = index + 1;
                index++;
            }
            String fileName = name.substring(start, name.length());
            int cnt = lastTab - tab;
            while (cnt >= 0) {
                cur -= (queue.pop().length() + 1);
                cnt--;
            }
            cur += (fileName.length() + 1);
            queue.push(fileName);
            if (fileName.contains(".")) {
                res = Math.max(res, cur);
            }
            lastTab = tab;
        }
        return res - 1;
    }
}
