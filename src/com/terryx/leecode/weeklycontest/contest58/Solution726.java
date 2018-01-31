package com.terryx.leecode.weeklycontest.contest58;

import java.util.*;

/**
 * @author taoranxue on 1/30/18 10:40 PM.
 */
public class Solution726 {
    public String countOfAtoms(String formula) {
        if (formula == null || formula.length() == 0) {
            return "";
        }
        TreeMap<String, Integer> cnt = new TreeMap<>();
        solve(formula, 1, cnt);
        StringBuilder sb = new StringBuilder();
        for (String key : cnt.keySet()) {
            if (cnt.get(key) == 1) {
                sb.append(key);
            } else if (cnt.get(key) > 1) {
                sb.append(key).append(cnt.get(key));
            }
        }
        return sb.toString();
    }

    private void solve(String str, int time, TreeMap<String, Integer> cnt) {
        int index = 0;
        while (index < str.length() && str.charAt(index) != ')') {
            if (str.charAt(index) == '(') {
                int iStart = index + 1;
                int left = 0, right = 0;
                while (index < str.length()) {
                    if (str.charAt(index) == '(') left++;
                    if (str.charAt(index) == ')') right++;
                    index++;
                    if (left == right) break;
                }
                String inner = str.substring(iStart, index - 1);
                iStart = index;
                while (index < str.length() && Character.isDigit(str.charAt(index))) index++;
                int t = iStart < index ? Integer.parseInt(str.substring(iStart, index)) : 1;
                solve(inner, time * t, cnt);
            } else {
                int iStart = index++;
                while (index < str.length() && Character.isLowerCase(str.charAt(index))) index++;
                String element = str.substring(iStart, index);
                iStart = index;
                while (index < str.length() && Character.isDigit(str.charAt(index))) index++;
                int t = iStart < index ? Integer.parseInt(str.substring(iStart, index)) : 1;
                cnt.put(element, cnt.getOrDefault(element, 0) + time * t);
            }
        }
    }

    public static void main(String[] args) {
        Solution726 m = new Solution726();
        System.out.println(m.countOfAtoms("H2O"));
        System.out.println(m.countOfAtoms("H24O"));
        System.out.println(m.countOfAtoms("Mg(OH)2"));
        System.out.println(m.countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(m.countOfAtoms("(SO3)3(SO3)3"));
        System.out.println(m.countOfAtoms("(SO3)(SO3)"));
    }

}
