package com.terryx.tutorials.concurrency;

/**
 * @author taoranxue on 9/16/16 4:16 PM.
 */
public class Drop {
    // Message sent from producer
    // to consumer.
    private String message;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    public synchronized String take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        empty = false;
        this.message = message;
        notifyAll();


    }
}
