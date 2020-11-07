package com.java01_fundamental.lesson23_io_stream;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         *  IOStream
         */
        /* FileInputStream */
        FileInputStream inputFile = new FileInputStream("StreamIO.txt");
        System.out.println((char)inputFile.read());
    }
}
