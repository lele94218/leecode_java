package com.terryx.main;

import com.terryx.leecode.Solution109;
import com.terryx.leecode.Solution92;

import java.sql.SQLException;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    private final Object finalizerGuardian = new Object() {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    };

    public static void main(String args[]) throws SQLException {
        Solution109 solution109 = new Solution109();
        solution109.sortedListToBST(new ListNode(0));
    }

}
