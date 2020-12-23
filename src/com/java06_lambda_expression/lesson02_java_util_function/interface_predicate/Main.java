package com.java06_lambda_expression.lesson02_java_util_function.interface_predicate;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        /** With Anonymous Class */
        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isBlank();
            }
        };
        System.out.println(predicate1.test(""));
        System.out.println(predicate1.test("Adnin"));

        /** With Lambda Expression */
        Predicate<String> predicate2 = (value) -> value.isBlank();
        System.out.println(predicate2.test(""));
        System.out.println(predicate2.test("Adnin"));
    }
}
