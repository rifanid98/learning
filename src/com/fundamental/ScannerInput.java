package com.fundamental;

import java.util.Scanner;

public class ScannerInput {

    public static void main(String[] args) {
        /**
         * Scanner Input
         */
        Scanner Input = new Scanner(System.in);
        // one word
        String shortName = Input.next();
        System.out.println("Welcome " + shortName); // Adnin
        // all words in line
        String fullName = Input.nextLine();
        System.out.println("Welcome " + fullName);  // Adnin Rifandi
    }
}
