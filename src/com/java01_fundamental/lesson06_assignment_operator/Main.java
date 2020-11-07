package com.java01_fundamental.lesson06_assignment_operator;

public class Main {

    public static void main(String[] args) {
        /**
         * Operator Assignment
         * a = a + x -> a += x
         * a = a - x -> a -= x
         * a = a * x -> a *= x
         * a = a / x -> a /= x
         */
        // normal
        int a = 10;
        a = a + 10; // a = 10 + 10
                    // a = 20
        System.out.println(a); // 20

        // shorthand
        int b = 10;
        b += 10;    // b += 10
                    // b = b + 10
                    // b = 10 + 10
                    // b = 20;
        System.out.println(b); // 20
    }
}
