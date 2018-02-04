package com.terryx.leecode.classic.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author taoranxue on 10/30/17 11:03 PM.
 */
public class SpinLock implements Lock {
    boolean isLock = false;
    @Override
    synchronized public void lock() {
        while (isLock) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLock = true;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    synchronized public void unlock() {
        isLock = false;
        notify();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
