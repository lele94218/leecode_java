package com.terryx.effectivejava.serviceframework;

/**
 * Service provider interface
 * java.sql.Driver
 * @author taoranxue on 9/19/16 9:08 PM.
 */
public interface Provider {
    //Connection connect(String url, java.util.Properties info)
    Service newService();
}
