package com.terryx.tutorials.classes;

/**
 * @author taoranxue on 9/14/16 5:21 PM.
 */
public class LocalScreen {
    public void method() {

        new Runnable() {
            public void run() {
                // Prints "An anonymous Runnable"
                System.out.println(this.toString());

                // Prints "A LocalScreen object"
                System.out.println(LocalScreen.this.toString());

                // Won't compile! 'this' is a Runnable!
                //onMake(this);

                // Compiles! Refers to enclosing object
                onMake(LocalScreen.this);
            }

            public String toString() {
                return "An anonymous Runnable!";
            }
        }.run();
    }

    public String toString() {
        return "A LocalScreen object";
    }

    public void onMake(LocalScreen ls) {

    }

    public static void main(String[] args) {
        new LocalScreen().method();
    }
}
