package com.terryx.network.chatroom;

import java.io.*;
import java.net.Socket;

/**
 * @author taoranxue on 6/29/17 5:13 PM.
 */
public class ChatroomClient extends Thread {
    private BufferedReader in;
    private PrintWriter out;
    private String nikeName;
    private String input;
    private Socket socket;

    public ChatroomClient(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println("----------WELCOME TO CHATROOM----------");
        out.println("Your nickname: ");
        start();
    }

    @Override
    public void run() {
        synchronized (ChatroomServer.lock) {
            try {

                boolean exit = false;
                int cnt = 0;

                while (!exit) {
                    input = in.readLine();
                    if (cnt++ == 0) {
                        nikeName = input;
                        ChatroomServer.clientList.add(this);
                        System.out.println(nikeName + " login.");

                    } else if ("exit".equals(input)) {
                        exit = true;
                    } else {
                        pullMessage("<" + nikeName + " (" + ChatroomServer.calendar.getTime() + ")> " + input);
                    }
                    try {
                        ChatroomServer.lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    ChatroomServer.clientList.remove(this);
                    in.close();
                    out.close();
                    if (!socket.isClosed()) socket.close();

                    pullMessage("<" + nikeName + " (" + ChatroomServer.calendar.getTime() + ")> " + "is left.");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void pullMessage(String message) {
        System.out.println(message + " " + ChatroomServer.hasMessage);
        ChatroomServer.messageList.offer(message);
        ChatroomServer.hasMessage = true;
        System.out.println("over " + ChatroomServer.hasMessage);


    }

    public void pushMessage(String message) {
        out.println(message);
    }
}
