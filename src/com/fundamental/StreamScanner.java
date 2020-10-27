package com.fundamental;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StreamScanner {

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
