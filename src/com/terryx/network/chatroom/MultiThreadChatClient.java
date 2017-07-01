package com.terryx.network.chatroom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author taoranxue on 7/1/17 5:49 PM.
 */
public class MultiThreadChatClient implements Runnable {

    private static Socket clientSocket = null;
    private static PrintStream os = null;
    private static BufferedReader is = null;
    private static boolean closed = false;
    private static Scanner scanner = null;

    @Override
    public void run() {
        String response;
        try {
            while ((response = is.readLine()) != null) {
                System.out.println(response);
                if (response.contains("*** Bye")) break;
            }
            closed = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        int portNumber = 18888;
        String host = "localhost";

        try {
            clientSocket = new Socket(host, portNumber);
            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            os = new PrintStream(clientSocket.getOutputStream());
            scanner = new Scanner(System.in);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (clientSocket != null && is != null && os != null) {
            try {
                new Thread(new MultiThreadChatClient()).start();
                while (!closed) {
                    os.println(scanner.nextLine().trim());
                }
                os.close();
                is.close();
                scanner.close();
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
