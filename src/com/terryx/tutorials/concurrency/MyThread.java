package com.terryx.tutorials.concurrency;

/**
 * @author taoranxue on 10/10/16 9:04 PM.
 */


public class MyThread extends Thread {

    private Sync sync;

    public MyThread(Sync sync) {
        this.sync = sync;
    }

    public void run() {
        sync.test();
    }


}
