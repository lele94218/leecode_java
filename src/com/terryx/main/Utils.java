package com.terryx.main;

/**
 * @author taoranxue on 9/23/16 2:14 AM.
 */
public class Utils {
    public static String debug(Object ... objects) {
        String str = "";
        for (int i = 0; i < objects.length; ++ i) {
            str += objects[i].toString();
            str += " ";
        }
        str += "\n";
        return str;
    }
}
