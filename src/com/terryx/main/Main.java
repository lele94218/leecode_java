package com.terryx.main;

import com.terryx.leecode.Solution109;
import com.terryx.leecode.Solution92;

import java.sql.SQLException;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    static void StairCase(int n) {
        for (int i = n - 1; i >= 0; --i) {
            String ss = "";
            for (int j = 0; j < i; ++ j) {
                ss += " ";
            }
            for (int j = 0; j < n - i; ++ j) {
                ss += "#";
            }
            System.out.println(ss);
        }
    }

    static int sum(int[] numbers) {
        long sum = 0;
        for (int a : numbers) {
            sum += (long) a;
        }
        return (int)sum;
    }

    private final Object finalizerGuardian = new Object() {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    };

    public static void main(String args[]) throws SQLException {
        StairCase(1);
    }

}
