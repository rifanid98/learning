package com.java06_lambda_expression.lesson02_java_util_function.interface_consumer;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        /** With anonymouse function */
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("Adnin");

        /** With Lambda Expression */
        Consumer<String> consumer2 = value -> System.out.println(value);
        consumer2.accept("Adnin");
    }
}
