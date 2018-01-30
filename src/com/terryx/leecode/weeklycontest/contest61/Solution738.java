package com.terryx.leecode.weeklycontest.contest61;

/**
 * @author taoranxue on 1/23/18 3:40 PM.
 */
public class Solution738 {
    public int monotoneIncreasingDigits(int N) {
        String s = Integer.toString(N);
        char cs[] = s.toCharArray();
        for (int i = cs.length - 1; i >= 1; -- i) {
            if (cs[i - 1] > cs[i]) {
                for (int j = i; j < cs.length; ++ j) {
                    cs[j] = '9';
                }
                cs[i - 1] -= 1;
            }
        }
        return Integer.parseInt(new String(cs));
    }

    public static void main(String[] args) {
        Solution738 m = new Solution738();
        System.out.println(m.monotoneIncreasingDigits(777616726));
        System.out.println(m.monotoneIncreasingDigits(10));
        System.out.println(m.monotoneIncreasingDigits(1234));
        System.out.println(m.monotoneIncreasingDigits(322));
    }
}
