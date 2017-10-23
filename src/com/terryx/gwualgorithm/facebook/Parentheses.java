package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/22/17 5:40 PM.
 */
public class Parentheses {
    /**
     * 301变形，仅返回一种情况即可
     */
    public String removeInvalidParentheses(String s) {
        int left = 0;
        StringBuilder sb = new StringBuilder();
        // left to right
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                left--;
            }
            if (left < 0) {
                sb.deleteCharAt(sb.length() - 1);
                left++;
            }
        }
        // right to left
        s = sb.toString();
        sb = new StringBuilder();
        int right = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            sb.insert(0, s.charAt(i));
            if (s.charAt(i) == ')') {
                right++;
            } else if (s.charAt(i) == '(') {
                right--;
            }
            if (right < 0) {
                sb.deleteCharAt(0);
                right++;
            }
        }
        return sb.toString();
    }

    public boolean checkValidString0(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return helper(s, new char[]{'(', ')'}) && helper(new StringBuilder(s).reverse().toString(), new char[]{')', '('});
    }

    private boolean helper(String s, char[] match) {
        int left = 0, right = 0, star = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == match[0]) {
                left++;
            } else if (c == match[1]) {
                right++;
            } else if (c == '*') {
                star++;
            }
            if (right > left + star) {
                return false;
            }
        }
        return left == right || right <= left + star;
    }

    public static void main(String[] args) {
        Parentheses i = new Parentheses();
        System.out.println(i.removeInvalidParentheses("()a)((--(()))"));
    }
}
