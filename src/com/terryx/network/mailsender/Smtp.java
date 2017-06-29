package com.terryx.network.mailsender;


import sun.misc.BASE64Encoder;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

/**
 * @author taoranxue on 6/28/17 6:28 PM.
 */
public class Smtp {

    private DataOutputStream dos;
    private Email email;

    public Smtp(Email email) {
        this.email = email;
    }

    private static final int DELAY = 1000;

    private class Receiver implements Runnable {
        private BufferedReader br;

        public Receiver(BufferedReader br) {
            this.br = br;
        }

        @Override
        public void run() {
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("SERVER: " + line);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void send() throws Exception {
        String username = new BASE64Encoder().encode(email.getUsername().getBytes());
        String password = new BASE64Encoder().encode(email.getPassword().getBytes());

        SSLSocket sock = (SSLSocket) (SSLSocketFactory.getDefault()).createSocket("smtp.gmail.com", 465);

        /* start new thread to get server response */
        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        Receiver receiver = new Receiver(br);
        Thread thread = new Thread(receiver);


        thread.start();
        dos = new DataOutputStream(sock.getOutputStream());

        send("EHLO smtp.gmail.com\r\n");
        Thread.sleep(DELAY);

        send("AUTH LOGIN " + username + "\r\n");
        Thread.sleep(DELAY);

        send(password + "\r\n");
        Thread.sleep(DELAY);

        send("MAIL FROM:<" + email.getUsername() + ">\r\n");
        Thread.sleep(DELAY);

        send("RCPT TO:<" + email.getSendTo() + ">\r\n");
        Thread.sleep(DELAY);

        send("DATA\r\n");
        Thread.sleep(DELAY);

        send("Subject: " + email.getSubject() + "\r\n");
        Thread.sleep(DELAY);

        send(email.getText() + "\r\n");
        Thread.sleep(DELAY);

        send(".\r\n");
        Thread.sleep(DELAY);

        send("QUIT\r\n");
        Thread.sleep(DELAY);

    }


    private void send(String s) throws Exception {
        dos.writeBytes(s);
        System.out.println("CLIENT: " + s.substring(0, s.lastIndexOf('\r')));
    }

}
