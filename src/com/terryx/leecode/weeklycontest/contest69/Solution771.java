package com.terryx.leecode.weeklycontest.contest69;

import java.util.*;

/**
 * @author taoranxue on 1/27/18 9:45 PM.
 */
public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < J.length(); ++i) {
            set.add((int) J.charAt(i));
        }

        int cnt = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (set.contains((int) S.charAt(i))) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution771 m = new Solution771();
        System.out.println(m.numJewelsInStones("aA", "aAAbbb"));
        System.out.println(m.numJewelsInStones("z", "ZZ"));
    }
}
