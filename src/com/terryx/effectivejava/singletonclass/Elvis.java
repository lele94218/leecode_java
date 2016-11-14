package com.terryx.effectivejava.singletonclass;

/**
 * @author taoranxue on 9/21/16 5:47 PM.
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {

    }
    public void leaveTheBuilding() {

    }
    //static factory
    public static Elvis getInstance() {
        return INSTANCE;
    }

    public final void main() {

    }
}
