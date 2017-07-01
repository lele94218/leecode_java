package com.terryx.network.chatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author taoranxue on 6/29/17 5:06 PM.
 */
public class ChatroomServer extends ServerSocket {
    static final Queue<String> messageList = new LinkedList<>();
    static final List<ChatroomClient> clientList = new LinkedList<>();
    static boolean hasMessage = false;
    static final Object lock = new Object();
    static final Calendar calendar = Calendar.getInstance();


    private static final int PORT = 18888;


    public ChatroomServer() throws IOException {

        super(PORT);

        System.out.println("_____________________________________");
        System.out.println("|---CSCI 6431 Computer Networking---|");
        System.out.println("|------Programming Problem 3.3------|");
        System.out.println("|--------Author: Taoran Xue---------|");
        System.out.println("|----------June 29, 2017------------|");
        System.out.println("-------------------------------------");

        new MessageHandler();

        try {
            for (; ; ) {
                Socket socket = this.accept();
                new ChatroomClient(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
    }



    public static void main(String args[]) throws IOException {
        ChatroomServer server = new ChatroomServer();
    }
}
