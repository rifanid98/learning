package com.java01_fundamental.lesson07_comparasion_operator;

public class Main {

    public static void main(String[] args) {
        /**
         * Operator Comparation (perbandingan)
         */
        int a = 10;
        int b = 10;
        int c = 11;
        // ==
        System.out.println(a == b); // true
        System.out.println(a == c); // false
        // !=
        System.out.println(a != b); // false
        System.out.println(a != c); // true
        // >
        System.out.println(a > b); // false
        System.out.println(a > c); // false
        // <
        System.out.println(a < b); // false
        System.out.println(a < c); // true
        // >=
        System.out.println(a >= b); // true
        System.out.println(a >= c); // false
        // <=
        System.out.println(a <= b); // true
        System.out.println(a <= c); // true
    }
}
