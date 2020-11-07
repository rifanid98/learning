package com.java01_fundamental.lesson05_unary_operator;

public class Main {

    public static void main(String[] args) {
        /**
         * Unary Operator
         */
        // +x; -x;
        int a = 1;
        System.out.println("Unary + = " + +a);  // 1 (positive)
        System.out.println("Unary - = " + -a);  // -1 (negative)

        // x++; x--;
        int b;
        b = 1; b++;
        System.out.println("Unary ++ = " + b); // 2
        b = 1; b--;
        System.out.println("Unary -- = " + b); // 0

        /**
         * Unary Postfix & Prefix;
         */
        // ++x; x++;
        int c;
        c = 1;
        System.out.println("Prefix = " + ++c); // 2 (ditambah dulu, baru diprint)
        c = 1;
        System.out.println("Postfix = " + c++); // 1 (diprint dulu, baru ditambah)
        System.out.println("Postfix = " + c); // 2

        /**
         * Unary Negasi
         */
        boolean d = true;
        System.out.println("Without negation = " + d); // true
        System.out.println("With negation = " + !d); // false (nilai kebalikan)
    }
}
