package com.java01_fundamental.lesson14_ternary_operator;

public class Main {

    public static void main(String[] args) {
        /**
         * Ternary Operator
         * int b = a == 20 ? a : 10;
         *
         * it's mean :
         * if (a == 20) {
         *    b = a;
         * } else {
         *    b = 10;
         * }
         */
        int a = 10;
        int b = a == 20 ? a : 10;
        System.out.println(b);  // 10
    }
}
