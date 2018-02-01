package com.terryx.interview.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/22/17 9:21 PM.
 */
public class NaturalStringCompare {
    /**
     * 让实现一个比较两道字符串的方法；前提是让字符串分block比较，相连的字母组成一个block，相连的数字组成一个block，
     * 比如“abcd12ef3”由4个block组成，两个字符串变成两组block之后对应的block挨个比较，如果对应的block一个是字母一个是数字，
     * 那么字母小于数字；如果对应的block都是字母，用的是String的标准的比较方法；如果对应的两个block都是数字，
     * 那么比较数字的绝对值大小。比如“abc12”大于"abc9"（第一个block相等，第二个block 12>9）, "a"小于“1”（字母小于数字），
     * “12abd”小于"12ab"（数字block一样，后面的字母block后者大）。
     */
    static class NaturalComparator implements Comparator<String> {
        /**
         * return negative num if l < r
         * 0  if l == r
         * positive if l > r
         */
        @Override
        public int compare(String a, String b) {
            int i = 0, j = 0, len = Math.min(a.length(), b.length());
            while (i < len || j < len) {
                char c1 = a.charAt(i), c2 = b.charAt(j);
                if (c1 == c2) {
                    ++i;
                    ++j;
                } else if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                    return c1 - c2;
                } else if (Character.isDigit(c1) && Character.isDigit(c2)) {
                    long num1 = 0, num2 = 0;
                    while (i < a.length() && Character.isDigit(a.charAt(i))) {
                        num1 = num1 * 10 + a.charAt(i) - '0';
                        i++;
                    }
                    while (j < b.length() && Character.isDigit(b.charAt(j))) {
                        num2 = num2 * 10 + b.charAt(j) - '0';
                        j++;
                    }
                    if (num1 == num2) {
                        continue;
                    }
                    return num1 < num2 ? -1 : 1;
                } else if (Character.isDigit(c1)) {
                    return 1;
                } else if (Character.isDigit(c2)) {
                    return -1;
                }
            }
            return i == a.length() && j == b.length() ? 0 : a.length() - b.length();
        }
    }

    public static void main(String[] args) {
        NaturalComparator comparator = new NaturalComparator();
        System.out.println(comparator.compare("a", "b") < 0);
        System.out.println(comparator.compare("abc9", "abc12") < 0);
        System.out.println(comparator.compare("azz00000111", "azz999") < 0);
        System.out.println(comparator.compare("a", "1") < 0);
        System.out.println(comparator.compare("1", "a") > 0);
        System.out.println(comparator.compare("", "aaaa") < 0);
        System.out.println(comparator.compare("1123444", "9999999999") < 0);
        System.out.println(comparator.compare("0000000000000001", "0") > 0);
        System.out.println(comparator.compare("a2b4z999", "a22b44z999") < 0);
        System.out.println(comparator.compare("a002b000444z", "a2b00444a") > 0);
        System.out.println(comparator.compare("a002b000444a001a", "a2b00444a00000000001a") == 0);
        System.out.println(comparator.compare("00001", "1") == 0);
        System.out.println(comparator.compare("abc", "abc99999999") < 0);
    }
}
