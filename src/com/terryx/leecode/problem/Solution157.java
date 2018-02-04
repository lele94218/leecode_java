package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 10/22/17 8:59 PM.
 */
public class Solution157 {
    class Reader4 {
        int read4(char[] buf) {
            return -1;
        }
    }

    public class Solution extends Reader4 {
        private final static int CAPACITY = 4;

        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return The number of characters read
         */
        public int read(char[] buf, int n) {
            char cache[] = new char[CAPACITY];
            int index = 0, cnt = 0, size = 0;
            while (cnt < n) {
                if (index < size) {
                    buf[cnt++] = cache[index++];
                } else {
                    index = 0;
                    size = read4(cache);
                    if (size <= 0) {
                        break;
                    }
                }
            }
            return cnt;
        }
    }
}
