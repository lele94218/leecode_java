package com.terryx.leecode.problem;

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
            int candidate = 0;
            for (int i = 1; i < n; ++i) {
                if (knows(candidate, i)) candidate = i;
            }
            for (int i = 0; i < n; ++i) {
                if (!knows(i, candidate)) return -1;
            }
            for (int i = 0; i < candidate; ++i) {
                if (knows(candidate, i)) return -1;
            }
            return candidate;
        }
    }
}
