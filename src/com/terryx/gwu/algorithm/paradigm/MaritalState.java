package com.terryx.gwu.algorithm.paradigm;

/**
 * @author taoranxue on 10/27/16 3:18 PM.
 */
public class MaritalState {
    public static final int SINGLE = 0;
    public static final int MARRIED = 1;
    public static final int DIVORCED = 2;
    public static final int WIDOW = 3;

    private int state;

    public MaritalState(int state) {
        this.state = state;
    }

    public void setState(int state) {
        if (this.state == SINGLE) {
            if (state == MARRIED) {
                this.state = state;
            } else {
                throw new IllegalArgumentException();
            }
        } else if (this.state == MARRIED) {
            if (state == DIVORCED || state == WIDOW) {
                this.state = state;
            } else {
                throw new IllegalArgumentException();
            }
        } else if (this.state == DIVORCED) {
            if (state == MARRIED || state == WIDOW) {
                this.state = state;
            } else {
                throw new IllegalArgumentException();
            }
        } else if (this.state == WIDOW) {
            if (state == MARRIED) {
                this.state = state;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public int getState() {
        return state;
    }
}
