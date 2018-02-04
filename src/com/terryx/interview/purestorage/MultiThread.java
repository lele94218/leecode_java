package com.terryx.interview.purestorage;

import com.terryx.leecode.lcode.concurrency.SpinLock;

import java.util.*;
import java.util.concurrent.locks.Lock;

/**
 * Q: Multi thread question: Event class has two methods,
 * void register(Callback cb); void fire();
 * it should run like this:
 *
 *
 * Event e = new Event();
 * e.register(cb1);// Not invoke until event is fired.
 * e.register(cb2);// Same
 * ...
 * e.fire(); // cb1.invoke(); cb2.invoke();
 * ...
 * e.register(cb3); // cb3.invoke() right away since event has been fired..
 *
 * @author taoranxue on 11/1/17 5:03 PM.
 */
public class MultiThread {
    interface Callback {
        void invoke();
    }

    interface Event {
        void register(Callback cb);

        void fire();
    }

    /**
     * Single thread version
     */
    class SingleThreadEvent implements Event {
        Queue<Callback> queue = new LinkedList<>();
        boolean isFired = false;

        @Override
        public void register(Callback cb) {
            if (!isFired) {
                queue.offer(cb);
            } else {
                cb.invoke();
            }
        }

        @Override
        public void fire() {
            while (!queue.isEmpty()) {
                queue.poll().invoke();
            }
            isFired = true;
        }
    }

    /**
     * if this is used in multi-thread condition, there are a couple of problem:
     * 1) if say register finished if check(isFired = false) and then fire is run
     * and finished(isFired = true), then cb in register is left in the queue
     * without anyone running.
     */
    class MultiThreadEvent implements Event {
        Queue<Callback> queue = new LinkedList<>();
        Lock mutex = new SpinLock();
        boolean isFired = false;

        @Override
        public void register(Callback cb) {
            mutex.lock();
            if (isFired) {
                queue.offer(cb);
            } else {
                cb.invoke();
            }
            mutex.unlock();
        }

        @Override
        public void fire() {
            mutex.lock();
            while (queue.isEmpty()) {
                queue.poll().invoke();
            }
            isFired = true;
            mutex.unlock();
        }
    }

    /**
     * But it is slow because invoke could take a long time.
     * The reason we put m.release() before cb.invoke() is
     * because invoke() we have no control and it could call
     * this.register again and because Mutex is not reentrant
     * we are going to have a deadlock and invoke can
     * take a long time which make everything slower.
     */
    class MultiThreadReentrantEvent implements Event {
        Queue<Callback> queue = new LinkedList<>();
        Lock mutex = new SpinLock();
        boolean isFired = false;

        @Override
        public void register(Callback cb) {
            mutex.lock();
            if (isFired) {
                queue.offer(cb);
                mutex.unlock();
            } else {
                mutex.unlock();
                cb.invoke();
            }
        }

        @Override
        public void fire() {
            mutex.lock();
            while (queue.isEmpty()) {
                Callback cb = queue.poll();
                mutex.unlock();
                cb.invoke();
                mutex.lock();
            }
            isFired = true;
            mutex.unlock();
        }
    }
}
