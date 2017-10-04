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
        int[] nums = new int[]{1,2,3,4,5};
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; ++ i) {
            if (nums[i] % 2 == 0) {
                dp[i] += 1;
            }

            if (i - 2 >= 0) {

                if (nums[i] % 2 == 1)
                    dp[i] += dp[i - 2] + 1 + dp[i - 1];
                else
                    dp[i] += dp[i - 2] + dp[i - 1];
            }

        }
        System.out.println(dp[nums.length - 1]);
    }

}
