package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/18/17 1:13 PM.
 */
public class Solution158 {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
    class Reader4 {
        int read4(char[] buf) {
            return -1;
        }
    }

    public class Solution extends Reader4 {
        char cache[] = new char[4];
        int cacheSize = 0;
        int cacheIdx = 0;

        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return The number of characters read
         */
        public int read(char[] buf, int n) {
            int cnt = 0;
            while (cnt < n) {
                if (cacheIdx < cacheSize) {
                    buf[cnt++] = cache[cacheIdx++];
                } else {
                    cacheSize = read4(cache);
                    cacheIdx = 0;
                    if (cacheSize <= 0) break;
                }
            }
            return cnt;
        }
    }
}
