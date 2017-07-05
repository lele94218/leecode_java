package com.terryx.network.dns;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author taoranxue on 7/1/17 6:28 PM.
 */
public class DnsClient {
    //    private static final String DNS_SERVER_ADDRESS = "192.168.1.1";
    private static final String DNS_SERVER_ADDRESS = "161.253.152.241";
    private static final int DNS_SERVER_PORT = 53;


    public void fun(String domain) {
        try {

            DatagramSocket socket = new DatagramSocket();

            ByteArrayOutputStream as = new ByteArrayOutputStream();
            DataOutputStream os = new DataOutputStream(as);

            /* 16 bits Identification */
            os.writeShort(0x241a);
            /* 16 bits Control (0x0100) */
            os.writeShort(0x0100);
            /* 16 bits Question count (one question)*/
            os.writeShort(0x0001);
            /* 16 bits Answer count (all zero) */
            os.writeShort(0x0000);
            /* 16 bits Authority count (all zero) */
            os.writeShort(0x0000);
            /* 16 bits Additional count (all zero) */
            os.writeShort(0x0000);


            /* 16 bits Query (www.google.com) */
            String[] words = domain.split("\\.");
            for (String word : words) {
                os.writeByte(word.length());
                os.write(word.getBytes());
            }
            os.writeByte(0x00);

            /* 16 bits Type (A) */
            os.writeShort(0x0001);

            /* 16 bits Type (0x0001) */
            os.writeShort(0x0001);

            DatagramPacket packet = new DatagramPacket(as.toByteArray(), as.size());
            packet.setAddress(InetAddress.getByName(DNS_SERVER_ADDRESS));
            packet.setPort(DNS_SERVER_PORT);

            socket.send(packet);

            System.out.println("SENT!");

            byte[] response = new byte[2048];
            packet.setData(response);
            socket.receive(packet);

            System.out.println("\n\nReceived: " + packet.getLength() + " bytes");

            for (int i = 0; i < packet.getLength(); ++i) {
                System.out.format("%x ", response[i]);
            }
            System.out.println();

            System.out.println("\n-----------Question-----------\n");
            int index = 0;
            System.out.println("Transaction ID: 0x" + String.format("%x", twoBytesToShort(response[index++], response[index++])));
            System.out.println("Flags: 0x" + String.format("%x", twoBytesToShort(response[index++], response[index++])));
            System.out.println("Questions count: 0x" + String.format("%x", twoBytesToShort(response[index++], response[index++])));
            short count = twoBytesToShort(response[index++], response[index++]);
            System.out.println("Answers count: 0x" + String.format("%x", count));
            System.out.println("Authority count: 0x" + String.format("%x", twoBytesToShort(response[index++], response[index++])));
            System.out.println("Additional count: 0x" + String.format("%x", twoBytesToShort(response[index++], response[index++])));
            String[] strs = getRecord(response, index).split(";");
            System.out.println("Question name: " + strs[0]);
            index = Integer.parseInt(strs[strs.length - 1]);
            System.out.println("Question type: 0x" + String.format("%x", twoBytesToShort(response[index++], response[index++])));

            System.out.println("Question class: 0x" + String.format("%x", twoBytesToShort(response[index++], response[index++])));

            while (count-- > 0) {

                System.out.println(String.format("\n-----------Answer: 0x%x-----------\n", count + 1));

                strs = getRecord(response, index).split(";");
                System.out.println("Answer name: " + strs[0]);
                index = Integer.parseInt(strs[strs.length - 1]);
                short type = twoBytesToShort(response[index++], response[index++]);
                System.out.println("Answer type: 0x" + String.format("%x", type));
                System.out.println("Answer class: 0x" + String.format("%x", twoBytesToShort(response[index++], response[index++])));
                System.out.println("Answer TTL: 0x" + String.format("%x", twoShortToInteger(twoBytesToShort(response[index++], response[index++]), twoBytesToShort(response[index++], response[index++]))));
                short len = twoBytesToShort(response[index++], response[index++]);
                System.out.println("Len: 0x" + String.format("%x", len));
                System.out.print("RData: ");
                if (type == 0x05) {
                    strs = getRecord(response, index).split(";");
                    index = Integer.parseInt(strs[strs.length - 1]);
                    System.out.println(strs[0]);
                } else if (type == 0x01) {
                    for (int i = 0; i < len; i++) {
                        System.out.print("" + String.format("%d", (response[index++] & 0xFF)) + ".");
                    }
                    System.out.println();
                }

                System.out.println("\n--------------------------------\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private short twoBytesToShort(byte b1, byte b2) {
        return (short) ((b1 << 8) | (b2 & 0xff));
    }

    private int twoShortToInteger(short s1, short s2) {
        return (int) ((s1 << 16) | (s2 & 0xffff));
    }

    private String getRecord(byte[] bytes, int index) {
        StringBuilder sb = new StringBuilder();
        while (index < bytes.length && bytes[index] != 0) {
            int len = bytes[index] & 0xff;
            if (index + 1 < bytes.length && (len & 0xc0) == 0xc0) {
                int pointer = twoBytesToShort((byte) len, bytes[++index]) & 0xffff;
                sb.append(getRecord(bytes, pointer & 0x3fff));
                break;
            }
            for (int i = 0; i < len; ++i) {
                sb.append((char) bytes[++index]);
            }
            sb.append('.');
            index++;
        }
        sb.append(";");
        sb.append(index + 1);
        return sb.toString();
    }

    public static void main(String args[]) {
        System.out.println("_____________________________________");
        System.out.println("|---CSCI 6431 Computer Networking---|");
        System.out.println("|------Programming Problem 3.2------|");
        System.out.println("|--------Author: Taoran Xue---------|");
        System.out.println("|----------June 29, 2017------------|");
        System.out.println("-------------------------------------");
        new DnsClient().fun("www.163.com");
    }
}
