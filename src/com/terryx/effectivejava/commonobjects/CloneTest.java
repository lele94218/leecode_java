package com.terryx.effectivejava.commonobjects;

/**
 * @author taoranxue on 10/7/16 3:19 PM.
 */
public class CloneTest implements Cloneable {
    @Override
    public CloneTest clone() throws CloneNotSupportedException {
        return (CloneTest)super.clone();
    }
}
