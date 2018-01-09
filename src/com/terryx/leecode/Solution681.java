package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/8/18 9:55 PM.
 */
public class Solution681 {
    public String nextClosestTime(String time) {
        if (time == null || time.length() != 5) {
            return time;
        }
        int map[] = new int[10];
        for (int i = 0; i < time.length(); ++i) {
            if (time.charAt(i) == ':') {
                continue;
            }
            map[time.charAt(i) - '0']++;
        }
        char res[] = time.toCharArray();
        for (int i = time.length() - 1; i >= 0; --i) {
            if (time.charAt(i) == ':') {
                continue;
            }
            for (int j = time.charAt(i) - '0' + 1; j < 10; ++j) {
                if ((i == 3 && j > 5) || (i == 0 && j > 2) || (i == 1 && res[0] == '2' && j > 4)) {
                    break;
                }
                if (map[j] > 0) {
                    res[i] = (char) (j + '0');
                    return new String(res);
                }
            }
            for (int j = 0; j < 10; ++ j) {
                if ((i == 3 && j > 5) || (i == 0 && j > 2) || (i == 1 && res[0] == '2' && j > 4)) {
                    break;
                }
                if (map[j] > 0) {
                    res[i] = (char) (j + '0');
                    break;
                }
            }
        }
        return new String(res);
    }
}
