package com.terryx.tutorials.iostreams;

import java.io.*;

/**
 * @author taoranxue on 7/9/17 6:16 PM.
 */
public class CopyCharacters {

    public static void main(String[] args) throws IOException {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("xanadu.txt");
            out = new FileWriter("outagain.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
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
