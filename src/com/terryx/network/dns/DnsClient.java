package com.terryx.network.dns;

import java.net.InetAddress;

/**
 * @author taoranxue on 7/1/17 6:28 PM.
 */
public class DnsClient {
    public static void main(String args[]) {
        try {
            InetAddress ip = InetAddress.getByName("yahoo.com");
            System.out.println(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
