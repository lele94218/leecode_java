package com.terryx.tutorials.classes;

/**
 * @author taoranxue on 9/14/16 4:51 PM.
 */
public class ShadowTest {
    private int x = 0;

    private class FirstLevel {
        private int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            // now this is FirstLevel
            System.out.println("this.x = " + this.x);
            // ShadowTest.this refers to this of the enclosing class.
            System.out.println("ShadowTest.this.x = ***" + ShadowTest.this.x);
            ShadowTest.NestedClass nestedClass = new ShadowTest.NestedClass();
            System.out.println("NestedClass.x = " + nestedClass.x);
        }
    }

    private static class NestedClass {
        private int x = 2;
    }

    public static void main(String args[]) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel firstLevel = st.new FirstLevel();

        firstLevel.methodInFirstLevel(23);
    }
}
