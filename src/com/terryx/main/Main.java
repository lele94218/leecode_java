package com.terryx.main;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.Stack;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    static class Student {
        int age;
        String name;

        public Student(String str) {
            name = str;
        }

        public void sayHello() {

        }
    }

    public static void fun() {
        System.out.println("Start of main program...");

        Student firstStudent = new Student("Tom");
        Student secondStudent = null;

        firstStudent.age = 18;
        firstStudent.sayHello();
//        throw new NullPointerException();
//        try {
            secondStudent.sayHello();
//        } catch (IllegalArgumentException e) {
//            System.out.println("===> Exceped error occured !" + e.toString());
//        }
//        System.out.println("End of main program ...");
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int b = 2147483647;
        int c = a + b;
        System.out.println(c + " " + (c - a));
    }

}
