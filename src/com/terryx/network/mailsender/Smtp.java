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

    private boolean ready = false;

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
                    synchronized (this) {
                        System.out.println("SERVER: " + line);
                        if (line.charAt(3) == ' ' && !"220".equals(line.substring(0, 3))) {
                            System.out.println("notifying..");
                            ready = true;
                            this.notifyAll();
                        }
                    }
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
        synchronized (receiver) {
            send("EHLO smtp.gmail.com\r\n");
            ready = false;
            while (!ready) {
                receiver.wait();
            }

            send("AUTH LOGIN " + username + "\r\n");

            ready = false;
            while (!ready) {
                receiver.wait();
            }
            send(password + "\r\n");

            ready = false;
            while (!ready) {
                receiver.wait();
            }

            send("MAIL FROM:<" + email.getSendTo() + ">\r\n");

            ready = false;
            while (!ready) {
                receiver.wait();
            }
            send("RCPT TO:<" + email.getUsername() + ">\r\n");

            ready = false;
            while (!ready) {
                receiver.wait();
            }

            send("DATA\r\n");

            ready = false;
            while (!ready) {
                receiver.wait();
            }

            send("Subject: " + email.getSubject() + "\r\n");
            send(email.getText() + "\r\n");
            send(".\r\n");

            ready = false;
            while (!ready) {
                receiver.wait();
            }

            send("QUIT\r\n");

            ready = false;
            while (!ready) {
                receiver.wait();
            }

            System.out.println("Sent!");
        }

    }


    private void send(String s) throws Exception {
        dos.writeBytes(s);
        System.out.println("CLIENT: " + s.substring(0, s.lastIndexOf('\r')));
    }

}
