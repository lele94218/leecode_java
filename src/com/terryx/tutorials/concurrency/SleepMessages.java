package com.terryx.tutorials.concurrency;

/**
 * @author taoranxue on 9/13/16 11:01 PM.
 */
public class SleepMessages {
    public static void main(String args[]) throws InterruptedException {
        String messages [] = {
                "apple",
                "banana",
                "candy",
                "dog"
        };
        for (String message : messages) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println(message);
        }
    }
}
