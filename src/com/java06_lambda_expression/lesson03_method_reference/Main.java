package com.java06_lambda_expression.lesson03_method_reference;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        /** With Anonymous Class */
        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return StringUtil.isLowerCase(s);
            }
        };
        System.out.println(predicate1.test("Adnin")); // false
        System.out.println(predicate1.test("adnin")); // true

        /** With Lambda Expression */
        Predicate<String> predicate2 = (value) -> StringUtil.isLowerCase(value);
        System.out.println(predicate2.test("Adnin")); // false
        System.out.println(predicate2.test("adnin")); // true

        /**
         * With Lambda Expression Method Reference Static
         *
         * Dengan method reference, kita bisa menggunakan lebih
         * dari satu parameter, tetapi tergantung dengan kontrak
         * dari si lambda interfacenya, jika hanya diberikan satu
         * parameter, maka kita hanya bisa pakai satu parameter.
         *
         * Solusinya, buatlah custom lambda interface sesuai dgn
         * kebutuhan.
         */
        Predicate<String> predicate3 = StringUtil::isLowerCase;
        System.out.println(predicate3.test("Adnin")); // false
        System.out.println(predicate3.test("adnin")); // true

        /** Method Reference di parameter */
        /* Instead like this */
        //Function<String, String> uppercase = value -> value.toUpperCase();
        /*
            You can type like this. You can use method reference of
            parameter type. if parameter type is String, you can use
            method reference of String object.
        */
        Function<String, String> uppercase = String::toUpperCase;
        System.out.println(uppercase.apply("Adnin")); // ADNIN
    }

    public void run() {
        /** With Anonymous Class */
        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return Main.this.isLowerCase(s);
            }
        };
        System.out.println(predicate1.test("Adnin")); // false
        System.out.println(predicate1.test("adnin")); // true

        /** With Lambda Expression */
        Main app = new Main();
        // cara 1
        Predicate<String> predicate2 = (value) -> this.isLowerCase(value);
        System.out.println(predicate2.test("Adnin")); // false
        System.out.println(predicate2.test("adnin")); // true
        // cara 2
        Predicate<String> predicateX = (value) -> app.isLowerCase(value);

        /** With Lambda Expression Method Reference Non Static */
        // cara 1
        Predicate<String> predicate3 = this::isLowerCase;
        System.out.println(predicate3.test("Adnin")); // false
        System.out.println(predicate3.test("adnin")); // true
        // cara 2
        Predicate<String> predicateY = app::isLowerCase;
    }

    public boolean isLowerCase(String s) {
        for(char c: s.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
