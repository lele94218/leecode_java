package com.terryx.main;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.*;

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

    public String removeSpace(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char s[] = str.toCharArray();
        int idx = 1;
        for (int i = 1; i < s.length; ++i) {
            if ((s[i] == ' ' && s[i - 1] != ' ') || (s[i] != ' ')) {
                s[idx] = s[i];
                idx++;
            }
        }
        return new String(s).substring(0, idx).trim();
    }

    public List<String> permutation(String str) {
        List<String> ans = new ArrayList<>();
        if (str == null) {
            return ans;
        }
        char[] c = str.toCharArray();
        Arrays.sort(c);
        dfs(c, 0, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(char[] str, int state, StringBuilder path, List<String> res) {
        if (path.length() == str.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < str.length; ++i)
            if ((state & (1 << i)) == 0) {
                if (i > 0 && str[i] == str[i - 1]
                        && (state & (1 << i - 1)) == 0) {
                    continue;
                }
                path.append(str[i]);
                dfs(str, (state | (1 << i)), path, res);
                path.deleteCharAt(path.length() - 1);
            }
    }

    public int kSmallestSum(int a[], int b[], int k) {
        if (a == null || b == null) {
            return -1;
        }
        int i = 0, j = 0, sum = 0;
        for (int cnt = 0; cnt < k; ++cnt) {
            sum = a[i] + b[j];
            if (a[i] < b[j] && i + 1 < a.length
                    || j + 1 >= b.length) {
                ++i;
            } else if (a[i] >= b[j] && j + 1 < b.length
                    || i + 1 > a.length) {
                ++j;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Main i = new Main();
        //System.out.println(i.kSmallestSum(new int[]{1,2,3,4,4,4,6}, new int[]{1,2,3}, 5));
        System.out.println(i.removeSpace("    f j df fds  d"));
    }

}
