package com.terryx.interview.facebook;

/**
 * @author taoranxue on 10/15/17 7:38 PM.
 */
public class IntegerToWords {
    String words[] = new String[]{"", "Thousand,", "Million,", "Billion,"};
    String numbers[] = new String[101];

    IntegerToWords() {
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
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        //
        int cnt = 0;
        String res = "";
        while (num > 0) {
            int a = num % 1000;
            if (a != 0) {
                res = parseNumber(a) + words[cnt] + " " + res;
            }
            cnt ++;
            num /= 1000;
        }
        res = res.trim();
        if (res.charAt(res.length() - 1) == ',') {
            res = res.substring(0, res.length() - 1);
        }
        return res;

    }

    private String parseNumber(int a) {
        if (a == 0) {
            return "";
        } else if (a / 100 > 0) {
            String tmp = parseNumber(a % 100);
            return numbers[a/100] + " " + numbers[100] + " " + ("".equals(tmp) ? "" : ("and " + tmp));
        } else if (a / 10 > 1) {
            return numbers[(a / 10) * 10] + " " + parseNumber(a % 10);
        } else {
            return numbers[a] + " ";
        }
    }

    public static void main(String[] args) {
        IntegerToWords i = new IntegerToWords();
        System.out.println(i.numberToWords(100100100));
    }
}
