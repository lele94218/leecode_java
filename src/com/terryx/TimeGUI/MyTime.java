package com.terryx.TimeGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author taoranxue on 12/12/16 5:32 PM.
 */
public class MyTime extends JFrame{

    private JPanel panel1;
    private JTextField textField1;
    private JButton chinaStandardTimeCSTButton;
    private JButton australianCentralACDTButton;
    private JButton alaskaStandardTimeStandardButton;
    private JTextField textField2;

    private String currTimeZone;

    public void setCurrTimeZone(String currTimeZone) {
        this.currTimeZone = currTimeZone;
    }

    public String getCurrTimeZone() {
        return currTimeZone;
    }

    private void setCurrentTime() {
        Date date = new Date();
        DateFormat convertDf = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        textField1.setText(convertDf.format(date));
    }

    private void setConvertTime() {
        Date date = new Date();
        DateFormat convertDf = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        convertDf.setTimeZone(TimeZone.getTimeZone(getCurrTimeZone()));
        textField2.setText(convertDf.format(date));
    }

    public MyTime() {
        //Basic GUI properties setup
        setContentPane(panel1);
        setSize(715, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        this.currTimeZone = "EST";

        chinaStandardTimeCSTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrTimeZone("GMT+8:00");
                setConvertTime();
            }
        });

        australianCentralACDTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrTimeZone("GMT+11:00");
                setConvertTime();
            }
        });

        alaskaStandardTimeStandardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrTimeZone("PST");
                setConvertTime();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        setCurrentTime();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        setConvertTime();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }

    public static void main(String args[]) {
        new MyTime();
    }
}
