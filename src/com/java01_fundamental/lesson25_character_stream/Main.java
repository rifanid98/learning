package com.java01_fundamental.lesson25_character_stream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * Character Stream
         */
        /* open file */
        FileInputStream fileInput = new FileInputStream("StreamIO.txt");
        FileReader      charFile  = new FileReader("StreamIO.txt");

        /* read file */
        System.out.println(fileInput.read());
        System.out.println(charFile.read());

        /* close file */
        fileInput.close();
        charFile.close();
    }
}
