package com.java06_lambda_expression.lesson02_java_util_function.interface_supplier;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        /** With Anonymous Class */
        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return "Adnin";
            }
        };
        System.out.println(supplier1.get());

        /** With Lambda Expression */
        Supplier<String> supplier2 = () -> "Adnin";
        System.out.println(supplier2.get());
    }
}
