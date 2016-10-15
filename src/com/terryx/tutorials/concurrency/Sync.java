package com.terryx.tutorials.concurrency;

/**
 * @author taoranxue on 10/10/16 9:12 PM.
 */
public class Sync {
    private static final Object monitor = new Object();
    public void test() {
        {

            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }
}
