package com.terryx.effectivejava.serviceframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Non-instantiable class for class registration and access
 * e.g. java.sql.DriverManager
 * @author taoranxue on 9/19/16 9:34 PM.
 */
public class Services {
    private Services() {

        // prevent instantiation. NOTE: it means Services cannot be subclassed.
    }

    //Map service names to services
    //private final static CopyOnWriteArrayList<DriverInfo> registeredDrivers = new CopyOnWriteArrayList<>();
    private static final Map<String, Provider> provider = new ConcurrentHashMap<>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    //Provider register API
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }
    //public static synchronized void registerDriver(java.sql.Driver driver)
    public static void registerProvider(String name, Provider p) {
        provider.put(name, p);
    }

    //Service access API
    //public static Connection getConnection(String url)
    public static Service getInstance(String name) {
        Provider p = provider.get(name);
        if (p == null)
            throw new IllegalArgumentException("No provider registered with name: " + name);
        return p.newService();
    }
}
