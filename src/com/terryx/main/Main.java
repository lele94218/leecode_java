package com.terryx.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {

// If we want to use strings to form a chain. Use recursion to find legal permutation.

    public boolean isChain(String[] strs) {
        if (strs == null || strs.length == 0) {
            return true;
        }
// chose start string;
        for (int i = 0; i < strs.length; ++ i) {
            if (dfs(strs, i, 1 << i)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(String[] strs, int cur, int used) {
        //0b1111 -> n strings both used
        if (used == (1 << strs.length) - 1) {
            return true;
        }
        String start = strs[cur];
        for (int i = 0; i < strs.length; ++ i) {
            // not used string i
            if (((1 << i) & used) == 0) {
                if (start.charAt(start.length() - 1)
                        == strs[i].charAt(0)) {
                    if (dfs(strs, i, used | (1 << i))) {
                        // once find, return true for pruning
                        return true;
                    }
                }
            }
        }
        return false;
    }



    public static void main(String[] args) throws InterruptedException {
        String str = "\tfjdslkajflkdjs";
        System.out.println(str.substring(str.indexOf("\t") + 2));
    }


}
