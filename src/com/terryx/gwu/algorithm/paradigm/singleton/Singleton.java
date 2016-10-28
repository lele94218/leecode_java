package com.terryx.gwu.algorithm.paradigm.singleton;

/**
 * @author taoranxue on 10/28/16 1:44 PM.
 */
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {

    }
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
