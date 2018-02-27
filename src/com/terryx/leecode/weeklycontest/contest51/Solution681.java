package com.terryx.leecode.weeklycontest.contest51;

import java.util.*;

/**
 * @author taoranxue on 2/26/18 9:01 PM.
 */
public class Solution681 {
    public String nextClosestTime(String time) {
        int cnt[] = new int[10];
        for (int i = 0; i < time.length(); ++i) {
            char c = time.charAt(i);
            if (c == ':') continue;
            cnt[c - '0'] = 1;
        }
        char t = '0';
        for (int i = 0; i < 10; ++ i) {
            if (cnt[i] != 0) {
                t = (char)(i + '0');
                break;
            }
        }
        char[] nextTime = time.toCharArray();
        for (int i = nextTime.length - 1; i >= 0; --i) {
            if (nextTime[i] == ':') continue;
            char c = nextTime[i];
            for (int j = c - '0' + 1; j < 10; ++j) {
                if (cnt[j] != 0) {
                    nextTime[i] = (char) (j + '0');
                    if ((nextTime[0] - '0') * 10 + nextTime[1] - '0' < 24
                            && (nextTime[3] - '0') * 10 + nextTime[4] - '0' < 60) {
                        for (int k = i + 1; k < nextTime.length; ++ k) {
                            if (nextTime[k] == ':') continue;
                            nextTime[k] = t;
                        }
                        return new String(nextTime);
                    }
                    nextTime[i] = c;
                }
            }
        }
        return (t + "" + t + ":" + t + "" + t);
    }

    public static void main(String[] args) {
        Solution681 m = new Solution681();
        System.out.println(m.nextClosestTime("19:34"));
        System.out.println(m.nextClosestTime("23:59"));
        System.out.println(m.nextClosestTime("13:55"));
    }
}
