package com.terryx.network.chatroom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 * @author taoranxue on 7/1/17 4:23 PM.
 */
public class MultiThreadChatServer {
    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;

    private static final int maxClientsCount = 10;
    private static final ClientThread[] threads = new ClientThread[maxClientsCount];

    public static void main(String args[]) {
        int portNumber = 18888;

        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (; ; ) {
            try {
                clientSocket = serverSocket.accept();
                int i = 0;
                for (i = 0; i < maxClientsCount; ++i) {
                    if (threads[i] == null) {
                        (threads[i] = new ClientThread(clientSocket, threads)).start();
                        break;
                    }
                }

                if (i == maxClientsCount) {
                    PrintStream os = new PrintStream(clientSocket.getOutputStream());
                    os.println("Server too busy, Try later.");
                    os.close();
                    clientSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientThread extends Thread {
        private BufferedReader is = null;
        private PrintStream os = null;
        private Socket clientSocket = null;
        private final ClientThread[] threads;
        private int maxClientsCount;

        public ClientThread(Socket clientSocket, ClientThread[] threads) {
            this.clientSocket = clientSocket;
            this.threads = threads;
            maxClientsCount = threads.length;
        }

        public void run() {
            int maxClientsCount = this.maxClientsCount;
            ClientThread[] threads = this.threads;
            try {
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new PrintStream(clientSocket.getOutputStream());
                os.println("Your nickname: ");
                String name = is.readLine().trim();
                os.println("<(" + Calendar.getInstance().getTime() + ")> Hello " + name + " to our chat room.\nTo leave enter /quit in a new line.");

                synchronized (this) {
                    for (int i = 0; i < maxClientsCount; ++i) {
                        if (threads[i] != null && threads[i] != this) {
                            threads[i].os.println("<(" + Calendar.getInstance().getTime() + ")>***  A new user " + name + " entered the chat room");
                        }
                    }
                }
                for (; ; ) {
                    String line = is.readLine();
                    if (line.startsWith("/quit")) {
                        break;
                    }

                    synchronized (this) {
                        for (int i = 0; i < maxClientsCount; ++i) {
                            if (threads[i] != null) {
                                threads[i].os.println("<" + name + "(" + Calendar.getInstance().getTime() + ")> " + line);
                            }
                        }
                    }
                }


                synchronized (this) {
                    for (int i = 0; i < maxClientsCount; ++i) {
                        if (threads[i] != null && threads[i] != this) {
                            threads[i].os.println("<(" + Calendar.getInstance().getTime() + ")> *** The user " + name + " is leaving the chat room !!! ***");
                        }
                    }
                }

                os.println("<(" + Calendar.getInstance().getTime() + ")>***  Bye " + name + " ***");


                synchronized (this) {
                    for (int i = 0; i < maxClientsCount; ++i) {
                        if (threads[i] == this) {
                            threads[i] = null;
                        }
                    }
                }

                is.close();
                os.close();
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

