package com.terryx.network.chatroom;

/**
 * @author taoranxue on 6/29/17 5:24 PM.
 */
public class MessageHandler extends Thread {
    public MessageHandler() {
        start();
    }

    @Override
    public void run() {
        synchronized (ChatroomServer.lock) {
            System.out.println("good!");
            for (; ; ) {
                if (ChatroomServer.hasMessage) {
                    System.out.println("good!");
                    String message = ChatroomServer.messageList.poll();
                    for (ChatroomClient client : ChatroomServer.clientList) {
                        client.pushMessage(message);
                    }
//                synchronized (ChatroomServer.lock) {
                    ChatroomServer.hasMessage = false;
                    ChatroomServer.lock.notifyAll();
//                }
                }
            }
        }
    }
}
