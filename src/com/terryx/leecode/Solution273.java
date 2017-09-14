package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/14/17 1:47 PM.
 */
public class Solution273 {
    String words[] = new String[]{"", "Thousand", "Million", "Billion"};
    String numbers[] = new String[101];

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        numbers[1] = "One";
        numbers[2] = "Two";
        numbers[3] = "Three";
        numbers[4] = "Four";
        numbers[5] = "Five";
        numbers[6] = "Six";
        numbers[7] = "Seven";
        numbers[8] = "Eight";
        numbers[9] = "Nine";
        numbers[10] = "Ten";
        numbers[11] = "Eleven";
        numbers[12] = "Twelve";
        numbers[13] = "Thirteen";
        numbers[14] = "Fourteen";
        numbers[15] = "Fifteen";
        numbers[16] = "Sixteen";
        numbers[17] = "Seventeen";
        numbers[18] = "Eighteen";
        numbers[19] = "Nineteen";
        numbers[20] = "Twenty";
        numbers[30] = "Thirty";
        numbers[40] = "Forty";
        numbers[50] = "Fifty";
        numbers[60] = "Sixty";
        numbers[70] = "Seventy";
        numbers[80] = "Eighty";
        numbers[90] = "Ninety";
        numbers[100] = "Hundred";
        // My version
        // String ans[] = new String[4];
        // int cnt = 0;
        // while (num > 0) {
        //     int n = num % 1000;
        //     StringBuilder sb = new StringBuilder();
        //     int a = n / 100;
        //     if (a > 0) {
        //         sb.append(numbers[a] + " " + numbers[100]);
        //         if (n % 100 != 0) sb.append(" ");
        //     }
        //     n %= 100;
        //     if (n <= 20) {
        //         sb.append((n > 0 ? numbers[n] : ""));
        //     } else {
        //         sb.append(numbers[n / 10 * 10] + ((n % 10 > 0) ? (" " + numbers[n % 10]) : ""));
        //     }
        //     if (cnt > 0 && (num % 1000) > 0) {
        //         sb.append(" " + words[cnt]);
        //     }
        //     ans[cnt] = sb.toString();
        //     num /= 1000;
        //     cnt ++;
        // }
        // StringBuilder res = new StringBuilder();
        // for (int i = ans.length - 1; i >= 0; -- i) {
        //     if (ans[i] != null && ans[i].length() != 0) {
        //         res.append(ans[i] + " ");
        //     }
        // }
        // String str = res.toString();
        // if (str.charAt(str.length() - 1) == ' ') str = str.substring(0, str.length() - 1);
        // return str;

        // Simple version
        int cnt = 0;
        String res = "";
        while (num > 0) {
            if (num % 1000 > 0) {
                res = helper(num % 1000) + words[cnt] + " " + res;
            }
            cnt++;
            num /= 1000;
        }
        return res.trim();
    }

    String helper(int num) {
        if (num == 0) return "";
        if (num <= 20) return numbers[num] + " ";
        if (num < 100) return numbers[num / 10 * 10] + " " + helper(num % 10);
        return numbers[num / 100] + " " + numbers[100] + " " + helper(num % 100);
    }
}
