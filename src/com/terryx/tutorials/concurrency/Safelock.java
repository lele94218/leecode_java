package com.terryx.tutorials.concurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author taoranxue on 9/16/16 6:00 PM.
 */
public class Safelock {
    static class Friend {
        private final String name;
        private final Lock lock = new ReentrantLock();

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public boolean bendingBow(Friend bower) {
            Boolean myLock = false;
            Boolean yourLock = false;
            try {
                myLock = lock.tryLock();
                yourLock = bower.lock.tryLock();
                System.out.println(this.name + ": " + myLock + ", " + bower.getName() + ": " + yourLock);
            } finally {
                if (!(myLock && yourLock)) {
                    System.out.println("doh!");
                    if (myLock) {
                        lock.unlock();
                    }
                    if (yourLock) {
                        bower.lock.unlock();
                    }
                }
            }
            return myLock && yourLock;
        }

        public void bow(Friend bower) {
            // both locked
            if (bendingBow(bower)) {
                try {
                    System.out.format("%s: %s" + " has bowed to me!%n", this.name, bower.getName());
                    bower.bowBack(this);
                    System.out.println("drag");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("unlock");
                    lock.unlock();
                    bower.lock.unlock();
                }
            } else {
                System.out.format("%s: %s started" + " to bow to me, but saw that" + " I was already bowing to" + " him.%n",
                        this.name, bower.getName());
            }
        }

        public void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    static class BowLoop implements Runnable {
        private Friend bower;
        private Friend bowee;

        public BowLoop(Friend bower, Friend bowee) {
            this.bower = bower;
            this.bowee = bowee;
        }

        public void run() {
            Random random = new Random();
            int cnt = 1;
            while (cnt-- > 0) {
//                try {
//                    Thread.sleep(random.nextInt(10));
//                } catch (InterruptedException e) {
//                }
                bowee.bow(bower);
            }
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new BowLoop(alphonse, gaston)).start();
        new Thread(new BowLoop(gaston, alphonse)).start();
    }
}
