package com.terryx.leecode.lcode.sort;

import java.util.*;

/**
 * @author taoranxue on 9/24/17 4:23 PM.
 */
public class SquareSpiral {
    public static String generate(int size) {
        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < size; ++h) {
            for (int w = 0; w < size; ++w) {
                if (h < size / 2) {
                    if (h % 2 == 0) {
                        if (w >= h && w < size - h) {
                            sb.append("*");
                        } else {
                            sb.append((w % 2 == 0) ? "*" : " ");
                        }
                    } else {
                        if (w >= h && w < size - h) {
                            sb.append(" ");
                        } else {
                            sb.append((w % 2 == 0) ? "*" : " ");
                        }
                    }
                } else {
                    if (h % 2 == 0) {
                        if (w < h - 1 && w >= size - h) {
                            sb.append("*");
                        } else {
                            sb.append((w % 2 == 0) ? "*" : " ");
                        }
                    } else {
                        if (w < h - 1 && w >= size - h) {
                            sb.append(" ");
                        } else {
                            sb.append((w % 2 == 0) ? "*" : " ");
                        }
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generate(121));
    }
}
