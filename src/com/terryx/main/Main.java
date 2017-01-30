package com.terryx.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main implements Cloneable{
    public static void main(String args[]) {
        Date date = new Date();
        DateFormat convertDf = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        convertDf.setTimeZone(TimeZone.getTimeZone("EST"));
        System.out.println(convertDf.format(date));
        convertDf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        System.out.println(convertDf.format(date));
    }
}
