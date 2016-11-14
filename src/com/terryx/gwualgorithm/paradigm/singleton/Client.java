package com.terryx.gwualgorithm.paradigm.singleton;

/**
 * @author taoranxue on 10/28/16 1:45 PM.
 */
public class Client {
    public static void main(String args[]) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1.equals(singleton2));
    }
}
