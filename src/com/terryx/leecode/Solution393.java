package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/6/17 1:51 PM.
 */
public class Solution393 {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return true;
        int idx = 0;
        while (idx < data.length) {
            int first = data[idx], cnt = 0, t = 1 << 7;
            while (t > 0 && (first & t) == t) {
                t >>= 1;
                cnt++;
            }
            System.out.println(cnt);
            if (cnt > 4 || cnt == 1) return false;
            idx++;
            for (int i = 0; i < cnt - 1; ++i) {
                if (idx >= data.length) return false;
                int ch = data[idx++];
                if ((ch & 0x80) != 0x80) return false;
            }
        }
        return true;
    }
}
