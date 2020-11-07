package com.java01_fundamental.lesson13_switch_case_statement;

public class Main {

    public static void main(String[] args) {
        /**
         * Switch Case
         */
        int a = 11;
        switch (a) {
            case 10:
                System.out.println("Nilainya 10");
                break;

            case 20:
                System.out.println("Nilainya 20");
                break;

            default:
                System.out.println("Tidak diketahui");
                break;
        }
    }
}
