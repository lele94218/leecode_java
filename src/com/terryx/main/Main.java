package com.terryx.main;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {

    List<String> permutation(String str) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(str);
        list.add(str);
        for (int i = 1; i < str.length(); ++i) {
            char c = sb.charAt(str.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, c);
            list.add(sb.toString());
        }
        return list;
    }

    void invert(String str) {
        List<StringBuilder> mat = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); ++j) {
                sb.append("*");
            }
            mat.add(sb);
        }
        for (int i = str.length() - 1; i >= 0; --i) {
            for (int j = 0; j < str.length(); ++j) {
                mat.get(j).replace(i, i + 1, "" + str.charAt(j));
            }

            for (StringBuilder sb : mat) {
                System.out.println(sb.toString());
            }
            System.out.println();

            Collections.sort(mat, new Comparator<StringBuilder>() {
                @Override
                public int compare(StringBuilder a, StringBuilder b) {
                    return a.toString().compareTo(b.toString());
                }
            });

            for (StringBuilder sb : mat) {
                System.out.println(sb.toString());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    }

}
