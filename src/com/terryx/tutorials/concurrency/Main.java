package com.terryx.tutorials.concurrency;

/**
 * @author taoranxue on 10/10/16 9:10 PM.
 */
public class Main {
    public static void main(String[] args) {
        Sync sync = new Sync();
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread(sync);
            thread.start();
        }
    }
}
