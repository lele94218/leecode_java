package com.terryx.tutorials.reflection;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author taoranxue on 9/17/16 4:30 PM.
 */
public class RetrievingClass {
    public RetrievingClass() throws NoSuchFieldException {
    }

    enum E {
        A, B
    };



    public static void main(String args[]) throws ClassNotFoundException, NoSuchFieldException {
        Class c = "foo".getClass();
        System.out.println(c);
        System.out.println(E.A.getClass());
        Set<String> s = new HashSet<>();
        System.out.println(s.getClass());
        boolean b = true;
        System.out.println(Boolean.class);
        System.out.println(double[].class);
        c = Class.forName("[D");
        System.out.println(c);
        c = Double.TYPE;
        System.out.println(c);
        c = JButton.class.getSuperclass();
        System.out.println(c);
        // only public classes
        Class<?>[] cs = Character.class.getClasses();
        System.out.println(cs[0] + ", " + cs[1] + ", " + cs[2]);
        // all classes
        cs = Character.class.getDeclaredClasses();
        System.out.println(cs.length);
        Field f = System.class.getDeclaredField("err");
        c = f.getDeclaringClass();
        System.out.println(c);
        c = Thread.State.class.getEnclosingClass();
        System.out.println(c);


    }
}
