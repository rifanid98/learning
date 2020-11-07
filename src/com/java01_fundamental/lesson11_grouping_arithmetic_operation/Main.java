package com.java01_fundamental.lesson11_grouping_arithmetic_operation;

public class Main {

    public static void main(String[] args) {
        /**
         * Operator aritmatik dikelompokkan dengan tanda ()
         * apabila operator aritmatik dikelompokkan, maka
         * operator tersebut akan dieksekusi terlebih dahulu
         * atau diprioritaskan
         */
        int a = 10;
        int b = 5;
        int c = 2;
        System.out.println(a + b * c);      // 20, karena perkalian akan didahulukan
        System.out.println((a + b) * c);    // 30, perjumlahan didahulukan karena dikelompokkan
    }
}
