package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 4:44 PM.
 */
public class Solution418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null) {
            return 0;
        }
        int next[] = new int[sentence.length], times[] = new int[sentence.length];
        for (int i = 0; i < sentence.length; ++i) {
            int curLen = 0, cur = i, time = 0;
            while (curLen + sentence[cur].length() <= cols) {
                curLen += (sentence[cur].length() + 1);
                cur++;
                if (cur == sentence.length) {
                    cur = 0;
                    time++;
                }
            }
            next[i] = cur;
            times[i] = time;
        }

        int res = 0, index = 0;
        for (int r = 0; r < rows; ++r) {
            res += times[index];
            index = next[index];
        }

        return res;
    }
}
