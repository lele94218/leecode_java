package com.terryx.tutorials.concurrency;

/**
 * @author taoranxue on 9/16/16 4:28 PM.
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Drop drop = new Drop();
        Producer producer = new Producer(drop);
        Consumer consumer = new Consumer(drop);
        (new Thread(producer)).start();
        (new Thread(consumer)).start();
    }
}
