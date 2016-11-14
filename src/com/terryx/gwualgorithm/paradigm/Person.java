package com.terryx.gwualgorithm.paradigm;

/**
 * @author taoranxue on 10/27/16 3:18 PM.
 */
public class Person {
    private String name;
    private MaritalState maritalState;

    public Person(String name, MaritalState maritalState) {
        this.name = name;
        this.maritalState = maritalState;
    }

    public String getName() {
        return name;
    }

    public MaritalState getMaritalState() {
        return maritalState;
    }

    public void setMaritalState(int state) {
        try {
            this.maritalState.setState(state);
            System.out.println("Valid!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid!");
        }
    }
}
