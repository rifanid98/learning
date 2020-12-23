package com.java06_lambda_expression.lesson05_lambda_as_lazy_parameter;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        testScore(90, getName()); // default
        testScore(70, () -> getName()); // lazy parameter
    }

    public static void testScore(int score, String name) {
        if (score > 80) {
            System.out.println("Selamat " + name + ", anda lulus!");
        } else {
            System.out.println("Maaf anda belum lulus.");
        }
    }

    public static void testScore(int score, Supplier<String> name) {
        if (score > 80) {
            System.out.println("Selamat " + name.get() + ", anda lulus!");
        } else {
            System.out.println("Maaf anda belum lulus.");
        }
    }

    public static String getName() {
        System.out.println("getName() called!");
        return "Adnin";
    }
}
