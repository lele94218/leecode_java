package com.terryx.main;

import com.terryx.leecode.contest35.Solution591;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    public static final Object lock = new Object();

    public static void main(String args[]) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        int total = 0;
                        for (int i = 0; i < 10000; ++i) {
                            total += i;
                        }
                        Thread.sleep(3000);
                        System.out.println("new thread running " + total);
                        this.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        synchronized (thread) {
            try {
                System.out.println("wait new thread");
                thread.wait();
                System.out.println("finally");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
