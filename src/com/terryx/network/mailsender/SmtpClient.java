package com.terryx.network.mailsender;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

/**
 * @author taoranxue on 6/28/17 6:25 PM.
 */
public class SmtpClient {

    public static void main(String args[]) throws Exception {
        System.out.println("_____________________________________");
        System.out.println("|---CSCI 6431 Computer Networking---|");
        System.out.println("|------Programming Problem 3.1------|");
        System.out.println("|--------Author: Taoran Xue---------|");
        System.out.println("|----------June 29, 2017------------|");
        System.out.println("-------------------------------------");

        Email email = new Email();
        System.out.println("\n\n\n\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your Gmail username (username@gmail.com):");
        String username = scanner.nextLine();
        System.out.println("Your Gmail password:");
        String password = scanner.nextLine();
        System.out.println("To:");
        String sendTo = scanner.nextLine();
        System.out.println("Subject:");
        String subject = scanner.nextLine();
        System.out.println("Text:");
        String text = scanner.nextLine();

        email.setUsername(username);
        email.setPassword(password);
        email.setSendTo(sendTo);
        email.setSubject(subject);
        email.setText(text);

        Smtp smtp = new Smtp(email);
        smtp.send();
        System.out.println("----------------LOG------------------");
        System.out.println("----------------END------------------");
    }

}
