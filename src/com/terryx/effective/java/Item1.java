package com.terryx.effective.java;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.EnumSet;

/**
 * @author taoranxue on 9/13/16 4:29 PM.
 */
public class Item1 {
    public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
        return null;
    }

    public enum Numbers{
        ONE, TWO, THREE, FOUR, FIVE, SIX
    }

    public static void main(String[] args) throws SQLException {
        /*
         * EnumSet Java Generic
         */
        EnumSet<Numbers> set = noneOf(Numbers.class);

        /*
         * 1. service interface: to implement. e.g. java.sql.Connection
         * 2. provider registration API: to register the interface. e.g. java.sql.DriverManager.registerDriver
         * 3. service access API: to obtain an instance of service. e.g. java.sql.DriverManager.getConnection
         * 4. service provide interface: providers implements create instance of service. e.g. java.sql.Driver
         *
         * synchronized is a keyword in Java which is used to make happens before relationship in multithreading
         * environment to avoid memory inconsistency and thread interference error. Keyword thread. Basically,
         * this allows not threads to overlap and stuff.
         */
        Connection connection = null;
//        DriverManager.registerDriver();
        DriverManager.getConnection("jdbc:mysql://localhost:3306/dataBase", "root", "root");
//        Driver
    }
}
