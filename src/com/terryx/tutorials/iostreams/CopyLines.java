package com.terryx.tutorials.iostreams;

import java.io.*;

/**
 * @author taoranxue on 7/9/17 6:23 PM.
 */
public class CopyLines {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new FileReader("xanadu.txt"));
            out = new PrintWriter(new FileWriter("characteroutput.txt"));

            String l;
            while ((l = in.readLine()) != null) {
                out.println(l);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
