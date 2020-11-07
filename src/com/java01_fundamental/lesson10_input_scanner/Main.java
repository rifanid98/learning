package com.java01_fundamental.lesson10_input_scanner;

import java.util.Scanner;

public class Main {

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
