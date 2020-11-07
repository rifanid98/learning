package com.java01_fundamental.lesson26_buffered_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * Stream Scanner
         */
        FileReader fileReader = new FileReader("StreamIO.txt");
        BufferedReader fileBuffer = new BufferedReader(fileReader);
        Scanner fileScanner = new Scanner(fileBuffer);
        System.out.println(fileScanner.next());
    }
}
