package com.java01_fundamental.lesson24_byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * Byte Stream
         *
         * close stream filenya dulu, baru buka file yang lain
         */
        /* open file */
        FileInputStream file = new FileInputStream("StreamIO.txt");
        FileOutputStream output = new FileOutputStream("SteamIO2.txt");

        /* read file */
        int data = file.read();
        String fileData = "";
        while (data != -1) {
            fileData += (char)data;
            data = file.read();
        }
        System.out.println(fileData);

        /* write file */
        output.write('A');

        /* close file */
        file.close();
        output.close();
    }
}
