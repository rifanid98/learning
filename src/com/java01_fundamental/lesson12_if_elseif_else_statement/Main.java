package com.java01_fundamental.lesson12_if_elseif_else_statement;

public class Main {

    public static void main(String[] args) {
        /**
         * IF ELSE
         */
        int a = 10;
        int b = 10;
        if (a == 10) {
            System.out.println("Nilainya sama");
        } else {
            System.out.println("Nilainya tidak sama");
        }

        /**
         * IF ELSE IF
         */
        if (a == 20) {
            System.out.println("Nilainya tidak sama, lanjut ke Else If");
        } else if (a == 11) {
            System.out.println("Nilainya tidak sama juga, lanjut ke Else");
        } else {
            System.out.println("Pada akhirnya ini akan diprint");
        }
    }
}
