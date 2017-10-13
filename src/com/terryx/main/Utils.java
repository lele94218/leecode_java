package com.terryx.main;

/**
 * @author taoranxue on 9/23/16 2:14 AM.
 */
public class Utils extends ListNode {
    protected int a;
    public void fun() {
        getS();
    }

    public Utils() {

    }

    public static void main(String args[]) {
        Utils utils = new Utils();
    }
    public static String debug(Object ... objects) {
        String str = "";
        for (int i = 0; i < objects.length; ++ i) {
            str += objects[i].toString();
            str += " ";
        }
        str += "\n";
        return str;
    }

    public static String debug(int[] nums) {
        String str = "";
        for (int i = 0; i < nums.length; ++ i) {
            str += nums[i];
            str += " ";
        }
        str += "\n";
        return str;
    }
}
