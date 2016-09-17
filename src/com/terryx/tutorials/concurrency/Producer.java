package com.terryx.tutorials.concurrency;

import java.util.Random;

/**
 * @author taoranxue on 9/16/16 4:19 PM.
 */
public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        Random random = new Random();

        for (String s : importantInfo) {
            drop.put(s);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drop.put("DONE");
    }
}
