package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/18/17 4:17 PM.
 */
public class Solution277 {
    class Relation {
        boolean knows(int a, int b) {
            return false;
        }
    }

    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int candid = 0;
            for (int i = 0; i < n; ++i) {
                if (knows(candid, i)) candid = i;
            }
            for (int i = 0; i < n; ++i) {
                if (knows(candid, i)) return -1;
            }
            for (int i = 0; i < n; ++i) {
                if (!knows(i, candid)) return -1;
            }
            return candid;
        }
    }
}
