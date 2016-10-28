package com.terryx.gwu.algorithm.paradigm;

/**
 * @author taoranxue on 10/27/16 3:27 PM.
 */
public class Client {
    public static void main(String args[]) {
        Person person = new Person("Peter", new MaritalState(MaritalState.SINGLE));
        person.setMaritalState(MaritalState.MARRIED);
        person.setMaritalState(MaritalState.SINGLE);
        person.setMaritalState(MaritalState.DIVORCED);
    }
}
