package com.terryx.interview.facebook;

/**
 * @author taoranxue on 10/15/17 7:47 PM.
 */
public class StringAdd {
    public String add(String a, String b, int radix) {
        if (a == null || b == null) {
            return "";
        }
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || c > 0) {
            int sum = (i >= 0 ? (a.charAt(i) - '0') : 0)
                    + (j >= 0 ? (b.charAt(j) - '0') : 0) + c;
            res.append((char) (sum % radix + '0'));
            c = sum / radix;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        StringAdd i = new StringAdd();
        System.out.println(i.add("9999", "9999", 10));
    }
}
