package com.java06_lambda_expression.lesson02_java_util_function.interface_function;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        /** With anonymous class */
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println(function1.apply("Adnin"));

        /** With Lambda Expression */
        Function<String, Integer> function2 = (value) -> value.length();
        System.out.println(function2.apply("Adnin"));
    }
}
