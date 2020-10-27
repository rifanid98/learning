package com.fundamental;

import java.io.FileInputStream;
import java.io.IOException;

public class StreamIO {

    public static void main(String[] args) throws IOException {
        /**
         *  IOStream
         */
        /* FileInputStream */
        FileInputStream inputFile = new FileInputStream("StreamIO.txt");
        System.out.println((char)inputFile.read());
    }
}
