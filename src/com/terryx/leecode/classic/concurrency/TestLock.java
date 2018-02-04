package com.terryx.leecode.classic.concurrency;

import java.util.concurrent.locks.Lock;

/**
 * @author taoranxue on 10/30/17 11:26 PM.
 */
public class TestLock {
    private TestLock() {

    }

    static class Counter {
        int cnt = 0;

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }

    static void testSpinLock() throws InterruptedException {
        Counter cnt = new Counter();
        Lock spinLock = new SpinLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; ++i) {
                    spinLock.lock();
                    cnt.setCnt(cnt.getCnt() + 1);
                    spinLock.unlock();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; ++i) {
                    spinLock.lock();
                    cnt.setCnt(cnt.getCnt() - 1);
                    spinLock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(500);
        assert (cnt.getCnt() == 0);
    }

    static class Reentrant {
        Lock lock = null;
        public Reentrant(Lock lock) {
            this.lock = lock;
        }

        public void outer() {
            lock.lock();
            System.out.println("outer");
            inner();
            lock.unlock();
        }

        public void inner() {
            lock.lock();
            System.out.println("inner");
            lock.unlock();
        }
    }

    static void testReentrant() {
        Reentrant t = new Reentrant(new ReentrantLock());
        t.outer();
    }


    public static void main(String[] args) throws InterruptedException {
        testSpinLock();
        testReentrant();
    }
}
