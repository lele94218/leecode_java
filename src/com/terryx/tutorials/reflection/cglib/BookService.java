package com.terryx.tutorials.reflection.cglib;

/**
 * @author taoranxue on 10/22/16 5:55 PM.
 */
public class BookService {
    public void add() {
        System.out.println("add one book here!");
    }

    @Override
    public String toString() {
        return "1";
    }
}
