package com.terryx.main;

import com.terryx.leecode.contest35.Solution591;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {

    public static void main(String args[]) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (Main.class) {
                        System.out.println("thread-1");
//                        Main.class.notifyAll();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        t.start();

        while (true) {
            synchronized (Main.class) {
                System.out.println("thread-0");
                Main.class.wait();
//                t.join();
            }
            Thread.sleep(400);

        }
    }

}
