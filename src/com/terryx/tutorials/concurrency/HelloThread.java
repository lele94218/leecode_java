package com.terryx.tutorials.concurrency;

/**
 * @author taoranxue on 9/13/16 10:36 PM.
 */
public class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }
}
