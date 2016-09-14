package com.terryx.tutorials.concurrency;

/**
 * @author taoranxue on 9/13/16 6:08 PM.
 */
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }
}
