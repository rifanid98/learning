package com.java01_fundamental.lesson08_logic_operator;

public class Main {

    public static void main(String[] args) {
        /**
         * Operator Logic
         */
        boolean a = true;
        boolean b = true;
        // &&
        System.out.println("&& (AND) = " + (a && b));   // true
        // ||
        System.out.println("|| (OR) = " + (a || b));    // true
        // ^
        System.out.println("^ (XOR) = " + (a ^ b));     // false
        // !
        System.out.println("! (NOT) = " + (!a));        // false
    }
}
