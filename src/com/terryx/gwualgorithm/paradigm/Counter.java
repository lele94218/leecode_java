package com.terryx.gwualgorithm.paradigm;

import java.util.Scanner;

/**
 * @author taoranxue on 11/2/16 3:38 PM.
 */
public class Counter {
    private boolean isStop = false;

    public void count() throws InterruptedException {
        int time = 0;
        while (!isStop) {
            System.out.println(time++);
            Thread.sleep(1000);
        }
    }

    public synchronized void setStop(boolean stop) {
        isStop = stop;
    }

    public static void main(String args[]) throws InterruptedException {
        Counter counter = new Counter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    counter.count();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (scanner.hasNextInt()) {
                    int flag = scanner.nextInt();
                    if (flag == 0) {
                        counter.setStop(true);
                        break;
                    }

                }
            }

        }).start();
    }
}
