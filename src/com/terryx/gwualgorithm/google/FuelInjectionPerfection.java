package com.terryx.gwualgorithm.google;

import java.math.BigInteger;

/**
 * @author taoranxue on 6/14/17 6:41 PM.
 */
public class FuelInjectionPerfection {
    static BigInteger one = BigInteger.valueOf(1);
    static BigInteger two = BigInteger.valueOf(2);
    static BigInteger zero = BigInteger.valueOf(0);

    public static int dfs(BigInteger n) {
        if (n.equals(one)) return 0;
        if (n.mod(two).equals(zero)) return dfs(n.divide(two)) + 1;
        return Math.min(dfs(n.add(one)) + 1, dfs(n.subtract(one)) + 1);
    }

    public static int answer1(String n) {
        // Your code goes here.
        BigInteger bn = new BigInteger(n);
        return dfs(bn);
    }

    public static int answer(String n) {
        BigInteger bn = new BigInteger(n);
        int cnt = 0;
        int oneCnt = 0;
        while (!bn.equals(zero)) {
            BigInteger mod = bn.mod(two);
            if (mod.equals(zero)) {
//                System.out.print(0);
                if (oneCnt == 0) {
                    cnt++;
                    oneCnt = 0;
                }
                else if (oneCnt == 1) {
                    cnt += 3;
                    oneCnt = 0;
                } else {
                    cnt = cnt + 1 + oneCnt;
                    oneCnt = 1;
                }
            } else {
//                System.out.print(1);
                oneCnt++;
            }
            System.out.println("=" + cnt);
            bn = bn.divide(two);
        }
        System.out.println(oneCnt);
        System.out.println();
        if (oneCnt <= 2) {
            if (oneCnt > 0) oneCnt--;
            if (oneCnt == 1) {
                cnt += 2;
            } else if (oneCnt > 1) {
                cnt = cnt + oneCnt;
            }
        } else {
            cnt = cnt + oneCnt + 1;
        }
        return cnt;
    }

    public static void main(String args[]) {
        System.out.println("----------1------------");
        System.out.println(answer("15"));
        System.out.println(answer1("15"));
        System.out.println("----------2------------");
        System.out.println(answer("9"));
        System.out.println(answer1("9"));
        System.out.println("----------3------------");
        System.out.println(answer("11"));
        System.out.println(answer1("11"));
        System.out.println("----------4------------");
        System.out.println(answer("13"));
        System.out.println(answer1("13"));
        System.out.println("----------5------------");
        System.out.println(answer("3"));
        System.out.println(answer1("3"));
        System.out.println("----------5------------");
        System.out.println(answer("7"));
        System.out.println(answer1("7"));
        System.out.println("----------5------------");
        System.out.println(answer("666"));
        System.out.println(answer1("666"));
    }
}
