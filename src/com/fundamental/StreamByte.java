package com.fundamental;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamByte {

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
