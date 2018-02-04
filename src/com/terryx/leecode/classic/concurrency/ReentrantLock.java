package com.terryx.leecode.classic.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author taoranxue on 10/30/17 11:48 PM.
 */
public class ReentrantLock implements Lock {
    boolean isLock = false;
    Thread lockedBy = null;
    int lockTime = 0;

    @Override
    synchronized public void lock() {
        Thread callingThread = Thread.currentThread();
        while (isLock && lockedBy != callingThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLock = true;
        lockedBy = callingThread;
        lockTime++;
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
        if (lockedBy == Thread.currentThread()) {
            lockTime--;
            if (lockTime == 0) {
                lockedBy = null;
                isLock = false;
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
