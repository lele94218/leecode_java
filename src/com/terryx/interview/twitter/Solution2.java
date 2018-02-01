package com.terryx.interview.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author taoranxue on 10/27/16 8:33 PM.
 */
public class Solution2 {
    static String decrypt(String encrypted_message) {
        int a[] = new int[]{8, 2, 5, 1, 2, 2, 0};
        List<Integer> decode = new ArrayList<>();
        for (int num : a) {
            decode.add(num);
        }
        String res = "";
        int k = 0;
        final String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        final String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < encrypted_message.length(); ++i) {
            char c = encrypted_message.charAt(i);
            if (!(Character.isUpperCase(c) || Character.isLowerCase(c))) {
                res += c;
                continue;
            }
            int add = decode.get(k % decode.size());
            if (Character.isUpperCase(c)) {
                int num = c - 'A';
                num -= add;
                if (num < 0) num += 26;
                c = upperAlphabet.charAt(num % 26);
            } else {
                int num = c - 'a';
                num -= add;
                if (num < 0) num += 26;
                c = lowerAlphabet.charAt(num % 26);
            }
            res += c;
            ++k;
        }
        return res;
    }

    static String decrypt1(String encrypted_message) {


        String code = encrypted_message.substring(encrypted_message.length() - 18, encrypted_message.length());
        code = code.toLowerCase();
        code = code.replace(",", "");
        code = code.replace(" ", "");
//        System.out.println(code);
        final String message = "yourfriendalice";
//        System.out.println(message);
        List<Integer> decode = new ArrayList<>();
        for (int i = 0; i < message.length(); ++i) {
            int diff = code.charAt(i) - message.charAt(i);
            if (diff < 0) diff += 26;
            decode.add(diff);
        }

        int finalLength = -1;
        for (int length = 1; length <= decode.size(); ++length) {
            List<Integer> decodeSub = decode.subList(0, length);
            boolean flag = true;
            for (int i = length; i < decode.size(); ++i) {
                if (!Objects.equals(decode.get(i), decodeSub.get(i % length))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                finalLength = length;
                break;
            }
        }
        if (finalLength > 0) {
            decode = decode.subList(0, finalLength);
        }

        for (int a : decode) {
            System.out.print(a + " ");
        }
        System.out.println();
        String res = "";

        String tmp = encrypted_message;
        Pattern p = Pattern.compile("[^a-zA-Z]");
        Matcher m = p.matcher(tmp);
        tmp = m.replaceAll("").trim();

        int k = decode.size() - (tmp.length() - 15) % decode.size();
        System.out.println(k);
        final String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        final String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < encrypted_message.length(); ++i) {
            if (encrypted_message.charAt(i) == ' ' || encrypted_message.charAt(i) == '.' || encrypted_message.charAt(i) == ',' || encrypted_message.charAt(i) == '-') {
                res += encrypted_message.charAt(i);
                continue;
            }
            char c = encrypted_message.charAt(i);
            int add = decode.get(k % decode.size());
            if (Character.isUpperCase(c)) {
                int num = c - 'A';
                num -= add;
                if (num < 0) num += 26;
                c = upperAlphabet.charAt(num);
            } else {
                int num = c - 'a';
                num -= add;
                if (num < 0) num += 26;
                c = lowerAlphabet.charAt(num);
            }
            res += c;
            ++k;
        }
        return res;
    }

    public static void main(String args[]) {
        String message = "Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg";
        System.out.println(message);
        System.out.println(decrypt(message));
    }
}
