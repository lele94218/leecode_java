package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/25/17 1:48 PM.
 */
public class Solution468 {
    public String validIPAddress(String IP) {

        if (IP.matches("((([1-9]?|1\\d|2[0-4])\\d|25[0-5])\\.){3}(([1-9]?|1\\d|2[0-4])\\d|25[0-5])")) return "IPv4";
        if (IP.matches("(?i)([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}")) return "IPv6";
        return "Neither";
    }
}
